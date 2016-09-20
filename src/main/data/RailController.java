package main.data;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class RailController {
	@Autowired
	RailDao raildDao;
	

   public RailDao getRaildDao() {
		return raildDao;
	}

	public void setRaildDao(RailDao raildDao) {
		this.raildDao = raildDao;
	}

	ServiceClass sc =new ServiceClass();;
	String start,end,userId;
	List<Booking> lo;
	@RequestMapping(value ={ "/","/Login"}, method = RequestMethod.GET)
	   public ModelAndView login() {
		   System.out.println("abhishelk");
	     return new ModelAndView("Login", "command", new Login());
		
	   }	
	
	@RequestMapping(value ="/validate", method = RequestMethod.POST)
	   public String validate(@ModelAttribute("SpringWeb")Login login) {
		System.out.println(login.getPassword()+login.getUserId());
		String f=  sc.validator(raildDao,login.getUserId(),login.getPassword());
	     
	     if(f.equalsIgnoreCase("User"))
	     {	userId=login.getUserId();
	    	 return "User";
	    	 }
	     if(f.equalsIgnoreCase("admin"))
	    	 {
	    	 return "Admin";}
	     else
	    	 return "Login";
	   }
	
	
@RequestMapping(value ="/search", method = RequestMethod.GET)
   public ModelAndView search() {
	   System.out.println("abhishelk");
     return new ModelAndView("search", "command", new availableTrains());
	
   }
  
@RequestMapping(value ="/Download", method = RequestMethod.GET)
public ModelAndView download(ModelMap model) {
	   System.out.println("abhishelk");
	   lo=sc.download(raildDao,userId);
	   model.addAttribute("ls",lo);
  return new ModelAndView("Download");
	
}


@RequestMapping(value ="/DownloadWithID", method = RequestMethod.GET)
public ModelAndView downloadWithUniqueID(ModelMap model,HttpServletRequest request) {
	   System.out.println("abhishelk"+request.getParameter("id"));
	   model.addAttribute("ls",lo);
	  model.addAttribute("Msg","Downloaded on Desktop with file name as "+request.getParameter("id"));
  return new ModelAndView("Download");
	
}

   @RequestMapping(value = "/availableTrains", method = RequestMethod.POST)
   public String availableTrains(@ModelAttribute("SpringWeb")availableTrains train, 
   ModelMap model) {
      start=train.getStart();
      end=train.getEnd();
        
        List<TrainDetailsWithStartAndEndStation> ls=sc.listOfTrains(raildDao,train.getStart(),train.getEnd());
          model.addAttribute("ls", ls);
          
          return "availableTrains";
   }
   
   @RequestMapping(value ={ "/trainDetails"}, method = RequestMethod.GET)
   public String trainDetails(@ModelAttribute("SpringWeb")availableTrains train, 
		   ModelMap model, HttpServletRequest request) {
	   
	   System.out.println("trainId  =>"+request.getParameter("id"));
	   
	  int trainId = Integer.parseInt(request.getParameter("id"));
	   List<trainDetails> list=sc.getTrainDetails(raildDao,trainId);
	   System.out.println("trainId " + trainId);
	   for (trainDetails trainDetails1 : list) {
		System.out.println(trainDetails1.getStationName()+" "+trainDetails1.getStartTime());
	}
	   model.addAttribute("trainNum",request.getParameter("id"));
	  model.addAttribute("train",list);
	  return "trainDetails";
    // return new ModelAndView("trainDetails", "command", new availableTrains());
	
   }
   
   @RequestMapping(value ={ "/passengerDetailsWithTrain"}, method = RequestMethod.GET)
   public ModelAndView passengerDetailsWithTrain(ModelMap model, HttpServletRequest request) {
	   int trainId =Integer.parseInt(request.getParameter("id"));
	   System.out.println(trainId+start+end);
	TrainDetailsWithStartAndEndStation d= sc.trainData(raildDao,trainId,start,end);
	System.out.println(d.getTrainNum() + "  " + d.getStationNamStart() + "  " + d.getStartTimeStart() + "  "
			+ d.getJourneyDayStart() + "  " + d.getHaultMinsStart() + "  " + d.getStationNameEnd() + "  "
			+ d.getStartTimeEnd() + "  " + d.getJourneyDayEnd() + "  " + d.getHaultMinsEnd());
	
	model.addAttribute("id",d);
	   
	   return new ModelAndView("PassengerDetails", "command", new PassangerDetails());
   }
  
   @RequestMapping(value ={ "/PassengerDetails"}, method = RequestMethod.GET)
   public ModelAndView PassangerDetails(@ModelAttribute("SpringWeb")PassangerDetails pdetails, 
		   ModelMap model, HttpServletRequest request) {
	  System.out.println("Want to see here"+request.getParameter("id"));
	  int trainId=Integer.parseInt(request.getParameter("id"));
	  model.addAttribute("uni",sc.storePassengerDetails(raildDao,pdetails,trainId,userId));
	System.out.println(pdetails.getPassangerName1()+"  "+pdetails.getAge1()+"  "+pdetails.getGender1()
	+"  "+pdetails.getPassangerName2()+"  "+pdetails.getAge2()+"  "+pdetails.getGender2()
	+"  "+pdetails.getPassangerName3()+"  "+pdetails.getAge3()+"  "+pdetails.getGender3()+"  "+trainId);
    return new ModelAndView("BookingResult", "command", new PassangerDetails());
	
   }
   
}