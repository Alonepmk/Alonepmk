package com.alonepmk.Mapper;

import com.alonepmk.Model.Account;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper
{

    public static final String New_Account_Field = "firstName, lastName, role, email, gender, city, country, password, emailConfirmC" +
"ode, confirmation"
;
    public static final String New_Account_Param = "#{firstName},#{lastName},#{role},#{email},#{gender},#{city},#{country},#{passwor" +
"d},#{emailConfirmCode},#{confirmation}"
;

    @Select("select * from account")
    public List<Account> getAllAccount();

    @Select("select * from account where id=#{id}")
    public Account getAccount(@Param("id") int id);

    @Select("select * from account where email=#{email} and password=#{password}")
    public Account getAccountByNameAndPassword(@Param("email") String email, @Param("password") String password);

    @Insert("INSERT INTO account ("+ New_Account_Field +") VALUES ( "+New_Account_Param+" )")
    public void addNewAccount(Account account);

    @Select("select count(email) from account where email=#{email}")
    public int checkAccountEmailExist(@Param("email") String email);

    public int isFirstTime(Account account);

    @Select("select * from account where email=#{email}")
    public Account getAccountByEmail(@Param("email") String email);

    @Select("select * from account where email=#{email} and password=#{password} and emailConfirmCode=#{code}")
    public Account getAccountByNameAndPasswordAndCode(
    		@Param("email") String email,@Param("password") String password,@Param("code") int code);

    @Update("update account set confirmation=#{i} where email=#{email}")
    public void setConfirmCode(@Param("i") int i,@Param("email") String email);
}
