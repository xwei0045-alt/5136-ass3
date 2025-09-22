package edu.monash.repo;
import java.io.*; import java.util.*; import java.time.LocalDate;
public class MembershipsRepo {
  private final String file;
  public static class Row { public String email,type,status; public LocalDate startDate,endDate; public Row(String e,String t,LocalDate s,LocalDate ed,String st){ email=e; type=t; status=st; startDate=s; endDate=ed; } }
  public final Map<String,Row> membership=new LinkedHashMap<>();
  public MembershipsRepo(String dir){ this.file=new File(dir,"memberships.csv").getPath(); }
  public void ensure() throws IOException { File f=new File(file); if(!f.exists()) try(PrintWriter pw=new PrintWriter(new FileWriter(f,true))){ pw.println("# email,type,startDate,endDate,status"); } }
  public void load() throws IOException { membership.clear(); File f=new File(file); if(!f.exists()) return; try(BufferedReader br=new BufferedReader(new FileReader(file))){ String l; while((l=br.readLine())!=null){ if(l.isBlank()||l.startsWith("#")) continue; String[] t=l.split(","); membership.put(t[0], new Row(t[0], t[1], java.time.LocalDate.parse(t[2]), java.time.LocalDate.parse(t[3]), t[4])); } } }
  public void save() throws IOException { try(PrintWriter pw=new PrintWriter(new FileWriter(file,false))){ pw.println("# email,type,startDate,endDate,status"); for(Row r:membership.values()) pw.printf("%s,%s,%s,%s,%s%n", r.email, r.type, r.startDate, r.endDate, r.status); } }
}
