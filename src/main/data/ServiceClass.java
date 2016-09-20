package main.data;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ServiceClass {

	public List<TrainDetailsWithStartAndEndStation> listOfTrains(RailDao raildDao, String start, String end) {
		System.out.println(raildDao);
		List<TrainByStation> at = raildDao.listTrains(start, end);
		List<Integer> traiNum = new ArrayList<Integer>();
		System.out.println("abhishelk 3");

		for (TrainByStation temp : at) {
			System.out.println(temp.getName());
			System.out.println(temp.getNum());
		}

		List<TrainByStation> mp = raildDao.trainStations(at);
		String sationName[];
		int flagStart = 0, flagEnd = 0, count = 0;
		for (TrainByStation trainByStation : mp) {
			System.out.println("num=>  " + trainByStation.getNum() + "  stations => " + trainByStation.getName());
			sationName = trainByStation.getName().split("/");
			flagStart = 0;
			flagEnd = 0;
			count = 0;
			for (String string : sationName) {
				System.out.println("num=>  " + trainByStation.getNum() + "  stations => " + string);
				count++;
				if (string.equalsIgnoreCase(start)) {
					flagStart = count;
				}
				if (string.equalsIgnoreCase(end)) {
					flagEnd = count;
				}

			}
			if (flagStart < flagEnd) {
				traiNum.add(trainByStation.getNum());
			}
		}

		for (Integer i : traiNum) {
			System.out.println("Train for journey =>" + i);

		}

		List<trainDetails> atData = raildDao.trainData(traiNum, start, end, 0);
		List<TrainDetailsWithStartAndEndStation> details = new ArrayList<>();
		atData.size();

		for (trainDetails trainDetails1 : atData) {

			if (trainDetails1.getStationName().equalsIgnoreCase(start)) {
				TrainDetailsWithStartAndEndStation obj = new TrainDetailsWithStartAndEndStation();
				obj.setTrainNum(trainDetails1.getTrainNum());
				obj.setStationNamStart(trainDetails1.getStationName());
				obj.setStartTimeStart(trainDetails1.getStartTime());
				obj.setJourneyDayStart(trainDetails1.getJourneyDay());
				obj.setHaultMinsStart(trainDetails1.getHaultMins());

				for (trainDetails trainDetails2 : atData) {
					if ((trainDetails1.getTrainNum() == trainDetails2.getTrainNum())
							&& (trainDetails2.getStationName().equalsIgnoreCase(end))) {
						obj.setStationNameEnd(trainDetails2.getStationName());
						obj.setStartTimeEnd(trainDetails2.getStartTime());
						obj.setJourneyDayEnd(trainDetails2.getJourneyDay());
						obj.setHaultMinsEnd(trainDetails2.getHaultMins());

					}

				}
				details.add(obj);
			}

		}
		for (TrainDetailsWithStartAndEndStation d : details) {
			System.out.println(d.getTrainNum() + "  " + d.getStationNamStart() + "  " + d.getStartTimeStart() + "  "
					+ d.getJourneyDayStart() + "  " + d.getHaultMinsStart() + "  " + d.getStationNameEnd() + "  "
					+ d.getStartTimeEnd() + "  " + d.getJourneyDayEnd() + "  " + d.getHaultMinsEnd());
		}
		return details;
	}

	public List<main.data.trainDetails> getTrainDetails(RailDao raildDao, int trainId) {
		List<trainDetails> atData = raildDao.trainData(null, null, null, trainId);
		for (trainDetails trainDetails : atData) {
			System.out.println(
					trainDetails.getTrainNum() + " " + trainDetails.getStationName() + " " + trainDetails.getStartTime()
							+ " " + trainDetails.getJourneyDay() + " " + trainDetails.getHaultMins());
		}
		return atData;
	}

	public String storePassengerDetails(RailDao raildDao, PassangerDetails pdetails, int trainId, String userId) {

		String unique = raildDao.storePassengerDetails(pdetails, trainId,userId);
		createPDF(pdetails, trainId, unique);
		return unique;

	}

	public void createPDF(PassangerDetails pdetails, int trainId, String unique) {
		String path = "C:\\Users\\prabhat\\Desktop\\abc\\" + unique + ".pdf";
		Document document = new Document();
		PdfPTable t = new PdfPTable(3);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
			document.add(
					new Paragraph("Your Ticket has been Booked in train number " + trainId + " your PNR is " + unique));

			document.add(new Paragraph("Please find the passenger Details below =>"));
			t.setSpacingBefore(25);

			t.setSpacingAfter(25);

			PdfPCell c1 = new PdfPCell(new Phrase("Passenger Name"));

			t.addCell(c1);

			PdfPCell c2 = new PdfPCell(new Phrase("Age"));

			t.addCell(c2);

			PdfPCell c3 = new PdfPCell(new Phrase("Gender"));

			t.addCell(c3);

			t.addCell(pdetails.getPassangerName1());
			t.addCell("" + pdetails.getAge1());
			t.addCell(pdetails.getGender1());
			if (pdetails.getPassangerName2() != "") {
				t.addCell(pdetails.getPassangerName2());

				t.addCell("" + pdetails.getAge2());

				t.addCell(pdetails.getGender2());
			}
			if (pdetails.getPassangerName3() != "") {
				t.addCell(pdetails.getPassangerName3());

				t.addCell("" + pdetails.getAge3());

				t.addCell(pdetails.getGender3());
			}

			document.add(t);
			document.add(new Paragraph("Happy Journey"));
			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public TrainDetailsWithStartAndEndStation trainData(RailDao raildDao, int trainId, String start, String end) {
		List<Integer> train = new ArrayList<>();
		train.add(trainId);
		List<trainDetails> atData = raildDao.trainData(train, start, end, 0);

		TrainDetailsWithStartAndEndStation data = new TrainDetailsWithStartAndEndStation();
		for (trainDetails trainDetails1 : atData) {
			if (trainDetails1.getStationName().equalsIgnoreCase(start)) {
				data.setTrainNum(trainId);
				data.setStationNamStart(start);
				data.setStartTimeStart(trainDetails1.getStartTime());
				data.setJourneyDayStart(trainDetails1.getJourneyDay());
				data.setHaultMinsStart(trainDetails1.getHaultMins());
			} else {
				data.setStationNameEnd(end);
				data.setStartTimeEnd(trainDetails1.getStartTime());
				data.setJourneyDayEnd(trainDetails1.getJourneyDay());
				data.setHaultMinsEnd(trainDetails1.getHaultMins());
			}
		}

		return data;
	}

	public String validator(RailDao raildDao, String userId, String password) {
		System.out.println("Service"+raildDao);
		String f=raildDao.vaildator(userId,password);
		return f;
	}

	public List<Booking> download(RailDao raildDao, String userId) {
		// TODO Auto-generated method stub
		List<Booking> list =raildDao.download(userId);
		for (Booking booking : list) {
			System.out.println(booking.getSeatBooked()+"  "+booking.getStatus()+"   "+booking.getUniqueId());
		}
		return list;
	}

}
