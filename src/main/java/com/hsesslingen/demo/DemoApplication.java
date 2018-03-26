package com.hsesslingen.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	private ArrayList<Date> times = new ArrayList<>();
	

	@GetMapping("/time")
	public String getTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	@PostMapping("/visit") 
	public void visit()
	{
		times.add(Calendar.getInstance().getTime());
	}

	@GetMapping("/logs")
	public String getLogs() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String s = "";
		for (Date d : times) {
			s += sdf.format(d);	
		}
		return s;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
