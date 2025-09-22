package edu.monash.repo;
import java.io.*; import java.util.*;
public class AccountsRepo {
  private final String file;
  public final Map<String,Double> balance=new LinkedHashMap<>();
  public AccountsRepo(String dir){ this.file=new File(dir,"accounts.csv").getPath(); }
  public void ensure() throws IOException { File f=new File(file); if(!f.exists()) try(PrintWriter pw=new PrintWriter(new FileWriter(f,true))){ pw.println("# email,balance"); } }
  public void load() throws IOException { balance.clear(); File f=new File(file); if(!f.exists()) return; try(BufferedReader br=new BufferedReader(new FileReader(file))){ String l; while((l=br.readLine())!=null){ if(l.isBlank()||l.startsWith("#")) continue; String[] t=l.split(","); balance.put(t[0], Double.parseDouble(t[1])); } } }
  public void save() throws IOException { try(PrintWriter pw=new PrintWriter(new FileWriter(file,false))){ pw.println("# email,balance"); for(var e:balance.entrySet()) pw.printf("%s,%.2f%n", e.getKey(), e.getValue()); } }
}
