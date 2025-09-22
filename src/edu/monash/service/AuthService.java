package edu.monash.service;
import edu.monash.repo.UsersRepo;
import edu.monash.repo.AccountsRepo;
public class AuthService {
  private final UsersRepo users; private final AccountsRepo accounts;
  public AuthService(UsersRepo u, AccountsRepo a){ this.users=u; this.accounts=a; }
  public String register(String email,String pwd){
    if(email==null||pwd==null||email.isBlank()||pwd.isBlank()) return "Email/password required";
    if(!email.endsWith("@student.monash.edu")) return "Only @student.monash.edu allowed";
    if(pwd.length()<6) return "Password too short (>=6)";
    if(users.users.containsKey(email)) return "Email already registered";
    users.users.put(email, new UsersRepo.Row(email, pwd, "CUSTOMER"));
    try { users.save(); } catch(Exception ignored){}
    if(!accounts.balance.containsKey(email)){ accounts.balance.put(email, 1000.00); try{ accounts.save(); }catch(Exception ignored){} }
    return "OK";
  }
  public boolean loginCustomer(String email,String pwd){
    UsersRepo.Row r = users.users.get(email);
    return r!=null && "CUSTOMER".equals(r.role) && r.password.equals(pwd);
  }
  public boolean loginAdmin(String email,String pwd){
    UsersRepo.Row r = users.users.get(email);
    return r!=null && "ADMIN".equals(r.role) && r.password.equals(pwd);
  }
}
