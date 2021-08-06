package address;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class adrsApp {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("********************");
	System.out.println("*전화번호 관리 프로그램*");
	System.out.println("********************");
	
	boolean bool = true;
	String line;
	PrintWriter pw = null;
	
	while(bool) {
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("---------------------------------");
        System.out.print(">메뉴번호:");
        
        int num = sc.nextInt();
        switch(num) {
        case 1:
        	System.out.println("<1.리스트>\n");
        	error();
        	break;
        	
        case 2:
        	try {
        		String[] add = new String[3];
        		System.out.println("<2.등록>");
        		System.out.println("-이름: ");
        		add[0] = sc.next();
        		
        		System.out.println("-휴대전화: ");
        		add[1] = sc.next();
        		
        		System.out.println("-집전화: ");
        		add[2] = sc.next();
        		
        		BufferedWriter bw = new BufferedWriter
        				(new FileWriter("list", true));
        		bw.write(add[0] + ", " + add[1] + ", " + add[2] + "\n");
        		bw.flush();
        		bw.close();
        		}
        	catch (FileNotFoundException e) { 
        		e.printStackTrace();
        	} catch(IOException e) {
        		e.printStackTrace();
        	} catch (Exception e) { 
        		e.printStackTrace();
        	}
        	System.out.println("\n[등록되었습니다.]\n");
        	break;
        	
        	case 3:
        		System.out.println("<3. 삭제>");
        		System.out.println("번호: ");
        		String delete = "";
        		int del = 0;
        		del = sc.nextInt();
        		
        		try {
        			File f = new File("list");
        			BufferedReader br = new BufferedReader(new FileReader(f));
        			for (int i = 0; i < del -1; i++) {
        				line = br.readLine();
        				delete += (line + "\r\n");
        				
        			}
        			String delData = br.readLine();
        					while((line = br.readLine()) != null) {
        						delete += (line + "\r\n");
        					}
        					FileWriter fw = new FileWriter("list");
        					fw.write(delete);
        					fw.close();
        					br.close();
        			} catch (FileNotFoundException e) {
        				e.printStackTrace();
        			} catch (IOException e) {
        				e.printStackTrace();
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
        		System.out.println("\n[삭제되었습니다.]\n");
	            break;
        case 4:
        	String search;
        	String lines = "";
        	System.out.println("<4. 검색>");
            System.out.print(">이름: ");
            search = sc.next();
            try {
            	File f = new File("list");
            	BufferedReader br = new BufferedReader(new FileReader(f));
            	while ((line = br.readLine())!= null) {
            		if (line.indexOf(search) != -1) {
            			lines = line;
            		}
            		    		
            	}
            	System.out.println(lines);
            	
            } catch (FileNotFoundException e) {
            	e.printStackTrace();
            } catch (IOException e) {
            	e.printStackTrace();
            } catch (Exception e) {
            	e.printStackTrace();
            }
            break;
        case 5:
        	 System.out.println("*********************************");
	            System.out.println("*   감사합니다      *");
	            System.out.println("*********************************");
	            bool = false;
	            break;
        default:
            System.out.println("\n[다시입력해주세요]\n");
            break;
        }
	}
	}
	private static void error() {
		try {
            File f = new File("list");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
            	System.out.println(line);
            }
            br.close();
         } catch (FileNotFoundException e) {
        	 e.printStackTrace();
         } catch(IOException e) {
        	 e.printStackTrace();
         } catch (Exception e) {
        	 e.printStackTrace();
        	 }
         System.out.println();
}
}
