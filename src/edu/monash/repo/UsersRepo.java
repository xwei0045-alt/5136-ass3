package edu.monash.repo;
import java.io.*; import java.util.*;
public class UsersRepo {
  private final String file;
  public static class Row { public String email,password,role; public Row(String e,String p,String r){ email=e; password=p; role=r; } }
  public final Map<String,Row> users=new LinkedHashMap<>();
  public UsersRepo(String dir){ this.file=new File(dir,"users.csv").getPath(); }
  public void ensure() throws IOException { File f=new File(file); if(!f.exists()) try(PrintWriter pw=new PrintWriter(new FileWriter(f,true))){ pw.println("# email,password,role"); } }
  public void load() throws IOException { users.clear(); File f=new File(file); if(!f.exists()) return; try(BufferedReader br=new BufferedReader(new FileReader(file))){ String line; while((line=br.readLine())!=null){ if(line.isBlank()||line.startsWith("#")) continue; String[] t=line.split(","); users.put(t[0], new Row(t[0], t[1], t[2])); } } }
  public void save() throws IOException { try(PrintWriter pw=new PrintWriter(new FileWriter(file,false))){ pw.println("# email,password,role"); for(Row r:users.values()) pw.printf("%s,%s,%s%n", r.email, r.password, r.role); } }
}
