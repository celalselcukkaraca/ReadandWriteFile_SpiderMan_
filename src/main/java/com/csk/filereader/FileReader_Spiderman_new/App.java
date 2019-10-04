package com.csk.filereader.FileReader_Spiderman_new;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        try{
        	
        	Scanner scan=new Scanner(new FileReader("Spider-Man.Far.from.Home.srt") );
        	int k=10; // filmin kaç sn geri olduğunu gösteren değer 
        	
        	String x="";
        	String y="";
        	String y1="";
        	String y2="";
        	
        	String y12="";
        	String y22="";
        	String yy="";
        	
        	String newtext="";
        	
        	int a;
        	int b;
        	int c;
        	String d="";
        	
        	String hr1="";
        	String min1="";
        	String sec1="";
        	String dec1="";
        	String time1="";
        	
        	String hr12="";
        	String min12="";
        	String sec12="";
        	String dec12="";
        	String time12="";
        	
        	String newtime="";
        	
        	String newfile="newfilespiderman.txt";
        	PrintWriter outfile=new PrintWriter(newfile);
        	
        	int newsec1;
        	int newmin1;
        	int newhr1;
        	
        	int newsec12;
        	int newmin12;
        	int newhr12;
        	
    		while(scan.hasNextLine()){
    			
    			String lineinfo=scan.nextLine();
    			//System.out.println(lineinfo);
    			x= x+""+ lineinfo +"\n";
    			
    			
    			if(lineinfo.contains("-->")){
    				String[] parts=lineinfo.split("-->");
    				y1=y1+parts[0]+"\n";  //  Ex:  00:00:47,420  (y1 tüm sol sutunların (parts[0]) bilgisini tutuyor)
        		    y2=y2+parts[1]+"\n";  //  Ex:  				    00:00:51,655 (y2 tüm sağ sutunların (parts[1] bilgisini tutuyor)
        			y= y+ lineinfo +"\n"; //  Ex:  00:00:47,420 --> 00:00:51,655  ( y ise tümü)
        			
        			hr1=(parts[0].substring(0,2));
        			//System.out.println(hr1);		
        			min1=(parts[0].substring(3,5));
        			//System.out.println(min1);
        			sec1=(parts[0].substring(6,8));
        			//System.out.println(sec1);
        			dec1=(parts[0].substring(8,12));
        			//System.out.println(dec1);
        			
        			hr12=(parts[1].substring(1,3));
	    			//System.out.println(hr12);		
	    			min12=(parts[1].substring(4,6));
	    			//System.out.println(min12);
	    			sec12=(parts[1].substring(7,9));
	    			//System.out.println(sec12);
	    			dec12=(parts[1].substring(9,13));
	    			//System.out.println(dec12);
        			
        			
        			newsec1= k+ Integer.parseInt(sec1);
        		//	System.out.println(sec1+ "fromto-->"+newsec1);
        			sec1=Integer.toString(newsec1);
        			newmin1=Integer.parseInt(min1);
        			newhr1=Integer.parseInt(hr1);
        			if(newsec1>=60){
        				
        				newmin1=Integer.parseInt(min1)+1;
        				newsec1=newsec1-60;
        				if(newsec1<10){
        					sec1="0"+Integer.toString(newsec1);
        				}else{
        					sec1=Integer.toString(newsec1);
        				}
        				
        				
        				if(newmin1>=60){
        					newhr1=Integer.parseInt(hr1)+1;
        					newmin1=newmin1-60;
        					min1=Integer.toString(newmin1);
        					if(newmin1<10){
        						min1="0"+Integer.toString(newmin1);
        					}else{
        						min1=Integer.toString(newmin1);
        					}
        					
        					if(newhr1<10){
        						
        						hr1="0"+Integer.toString(newhr1);
        					}else{
        						hr1=Integer.toString(newhr1);
        					}
        				}
        			}
        			
        			
        			time1=hr1+":"+ min1+":"+sec1+ dec1;
        		//	System.out.println("new time --->"+time1);
        			
        			newsec12= k+ Integer.parseInt(sec12);
        		//	System.out.println(sec12+ "fromto-->"+newsec12);
    	    		sec12=Integer.toString(newsec12);
    	    		newmin12=Integer.parseInt(min12);
    	    		newhr12=Integer.parseInt(hr12); 
    	    		
    	    		if(newsec12>=60){
	    				
	    				newmin12=Integer.parseInt(min12)+1;
	    				newsec12=newsec12-60;
	    				if(newsec12<10){
	    					sec12="0"+Integer.toString(newsec12);
	    				}else{
	    					sec12=Integer.toString(newsec12);
	    				}
	    				
	    				
	    				if(newmin12>=60){
	    					newhr12=Integer.parseInt(hr12)+1;
	    					newmin12=newmin12-60;
	    					min12=Integer.toString(newmin12);
	    					if(newmin12<10){
	    						min12="0"+Integer.toString(newmin12);
	    					}else{
	    						min12=Integer.toString(newmin12);
	    					}
	    					
	    					if(newhr12<10){
	    						
	    						hr12="0"+Integer.toString(newhr12);
	    					}else{
	    						hr12=Integer.toString(newhr12);
	    					}
	    				}
	    			}
	    			
	    			
	    			time12=hr12+":"+ min12+":"+sec12+ dec12;
	    	//		System.out.println("new time 2 --->"+time12);
        			
	    			newtime=newtime +time1+"--->"+time12+"\n";
        		//	System.out.println(newtime);
        			outfile.print(newtime);
        	
        			
    			}else{
    				
    				outfile.println(lineinfo);
    			}
    		
 		
    		
    		
    		}// while1 döngü sonu  ********************************
        
    	//	System.out.println(newtime);
    	
   
    		outfile.close();
    		
    		System.out.println(newtime);
    	
    		
    			   	
        	
        }
        
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
