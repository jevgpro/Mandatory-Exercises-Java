import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URL;
import java.io.*; 
import java.net.MalformedURLException; 

class Program implements myInterface{

    BufferedInputStream bins;
    InputStream inStr;
    public Program(){
        this.programStart();
        this.webRequest();
        this.saveHTML();
        this.programEnd();
    }

    public void programStart(){
        System.out.println("Kraapija alustab tööd.");
    }

    public void webRequest(){
        try
        {
            URL tempUrl = new URL("http://www.google.ru");
            inStr = tempUrl.openConnection().getInputStream();
            bins = new BufferedInputStream(inStr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void saveHTML(){
        try{
            FileOutputStream fostreame = new FileOutputStream("out.html");
            int c;
            while((c= bins.read())!=-1)
            {
                fostreame.write(c);
            }
            inStr.close();
            bins.close();
            fostreame.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void programEnd(){
        System.out.println("Kraapija sulgeb.");
    }

}

interface myInterface{
    public void programStart();
    public void webRequest();
    public void saveHTML();
    public void programEnd();
}