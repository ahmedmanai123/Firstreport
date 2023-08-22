package com.infybuzz.Firstreport;

import net.sf.jasperreports.engine.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@SpringBootApplication
public class FirstreportApplication {

	public static void main(String[] args) throws JRException {

		SpringApplication.run(FirstreportApplication.class, args);
		String filePath="C:\\spirng\\Firstreport\\src\\main\\resources\\FirstReport.jrxml";
		Map<String,Object>parameters=new HashMap<String,Object>();
		parameters.put("StudentName","John");
		Student student1=new Student(1,"Raj","Joshi","Happy Street","Delhi");
		Student student2=new Student(2,"Peter","Smith","Any Street","Mumbai");
		List<Student>list=new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(list);
		JasperReport report= JasperCompileManager.compileReport(filePath);
		 JasperPrint print=   JasperFillManager.fillReport(report,parameters,dataSource);
         JasperExportManager.exportReportToHtmlFile(print,"C:\\pr\\FirstReports.pdf");
         System.out.println("Reported created");
	}

}
