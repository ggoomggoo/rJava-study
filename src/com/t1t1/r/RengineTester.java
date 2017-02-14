package com.t1t1.r;

import org.rosuda.JRI.Rengine;

public class RengineTester {

	public static void main(String[] args) {
		
//		rJava 설치
//
//		install.packages("rJava")
//		library(rJava)
//
//		#환경변수 설정
//		#바탕화면-컴퓨터-마오-속성-고급시스템설정
//		#-환경변수-시스템변수-새로만들기
//
//		#1)
//		#R_HOME 변수 등록 (R-tool위치)
//		#(예) C:\Program Files\R\R-3.3.2
//
//		#2)
//		#시스템변수 Path 경로 지정
//		#(rJava 패키지를 설치한 프로그램의 위치)
//		#64bit : %R_HOME%\bin\x64; %R_HOME%\library\rJava\jri\x64;
//		#C:\Program Files\R\R-3.3.2\bin\x64;C:\Program Files\R\R-3.3.2\library\rJava\jri\x64;
//
//		#rJava
//		#JRI는 Java 애플리케이션에서 R을 실행할 수 있는
//		#Java-R 인터페이스
//		#Java에 R 동적 라이브러리를 로드하고
//		#R에 Java API를 제공
//
//		#Eclipse 설정
//		#1.자바 프로젝트 하나 생성-Rjava1
//		#2.생성된 프로젝트를 navigator 보기로 한후 다음,
//		#프로젝트 아래 lib폴더 하나 만들고
//		#C:\Program Files\R\R-3.3.2\library\rJava\jri 경로에 있는 3개 JAR 파일
//		#(JRI.jar, JRIEngine.jar, REngine.jar)을 모두 복사한다.
//		#3. 프로젝트-마오-property- Java Build Path-Library 탭에서
//		#Add JARs 하여 프로젝트 lib 방에 있는 jar를 모두 선택한다
//
//		#rJava 프로그램 작성하기		
//		
//		by KMS

		Rengine re1 = new Rengine(null, false, null);
		if (!re1.waitForR()) {
			System.out.println("에러났다는~~~");
			System.exit(1);
		}

		System.out.println("start");
		re1.eval("x<-c(1:10)");
		re1.eval("jpeg(filename=\"C:/R/rJava2.jpg\")");
		re1.eval("pie(x)");
		re1.eval("dev.off()");
		re1.end();
		System.out.println("end");
		
	}
	
}
