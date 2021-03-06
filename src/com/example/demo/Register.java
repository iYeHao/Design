package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Register {
	private String uname;
	private String upassword;
	private String cpassword;
	private String uemail;
	private String usex;
	private int ulevel;
	private int uage;
	/**
     * 存储校验不通过时给用户的错误提示信息
     */
    private Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }
    /*
     * validate方法负责校验表单输入项
     * 表单输入项校验规则：
     *         private String userName; 用户名不能为空，并且要是3-8的字母 abcdABcd 
     *         private String userPwd; 密码不能为空，并且要是3-8的数字
     *         private String confirmPwd; 两次密码要一致
     *         private String email; 可以为空，不为空要是一个合法的邮箱 
     *         private String birthday; 可以为空，不为空时，要是一个合法的日期
     */
    public boolean validate() {

        boolean isOk = true;

        if (this.uname == null || this.uname.trim().equals("")) {
            isOk = false;
            errors.put("uname", "*用户名不为空");
        } else {
          if (!this.uname.matches("[a-zA-Z]{3,8}")) 
        	  {  
                isOk = false;
                errors.put("uname", "*用户名为3-8位的字母");
            }
        }

        if (this.upassword == null || this.upassword.trim().equals(" ")) {
            isOk = false;
            errors.put("upassword", "*密码不为空");
        } else {
            if (!this.upassword.matches("\\d{3,8}")) {
                isOk = false;
                errors.put("upassword", "*密码为3-8位数字");
            }
        }

        // private String password2; 两次密码要一致
        if (this.cpassword != null) {
            if (!this.cpassword.equals(this.upassword)) {
                isOk = false;
                errors.put("cpassword", "*俩次密码不一致");
            }
        }      

        return isOk;
    }
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public void setUemail(String uemail){
		this.uemail=uemail;
	}
	public String getUemail(){
		return uemail;
	}
	public void setUname(String uname){
		this.uname=uname;
	}
	public String getUname(){
		return uname;
	}
	public void setUpassword(String upassword){
		this.upassword=upassword;
	}
	public String getUpassword(){
		return upassword;
	}
	public void setUage(int uage){
		this.uage=uage;
	}
	public int getUage(){
		return uage;
	}
	public void setUlevel(int ulevel){
		this.ulevel=ulevel;
	}
	public int getUlevel(){
		return ulevel;
	}
	public void setUsex(String usex){
		this.usex=usex;
	}
	public String getUsex(){
		return usex;
	}


}
