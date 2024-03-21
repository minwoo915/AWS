//액션 클래스는 MVC 패턴에서 컨트롤러 역할을 합니다. 
//액션 클래스는 사용자 액 션에 응답하고, 비즈니스 로직을 실행한 다음
//(또는 이를 수행하기 위해 다른 클래스를 호출), 렌더링할 뷰를 Struts에 알려주는 결과를 반환합니다.

//패키지: 디렉터리 혹은 폴더같은 개념이며 서로 관련있는 클래스 파일들을 패키지에 저장하여 관리
package struts2.action;

/*Struts2 Action 클래스는 일반적으로 Struts2 프레임워크에서 제공하는 ActionSupport 클래스를 확장합니다. 
 
Class ActionSupport는 가장 일반적인 액션(예: 실행, 입력)에 대한 
기본 구현을 제공하고 몇 가지 유용한 스트럿츠 2 인터페이스를 구현합니다.

액션 클래스가 클래스를 확장(extends)하면 기본 구현을 재정의하거나 상속할 수 있습니다.*/
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
	
	private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    
    /*execute: 작업의 논리가 실행되는 곳입니다. 
    아무것도 하지 않는 기본 구현은 "success"을 반환합니다.
    하위 클래스는 비즈니스 논리를 제공하기 위해 이 방법을 재정의해야 합니다.
    
    SUCCESS: 작업 실행이 성공했습니다. 최종 사용자에게 결과 보기를 표시합니다.*/
    public String execute() {
        return SUCCESS;
    }
  
    public String getUserName() {
        return userName;
    }
  
    public void setUserName(String userName) {
        this.userName = userName;
    }
  
    public String getPassword() {
        return password;
    }
  
    public void setPassword(String password) {
        this.password = password;
    }
  
    public String getPhoneNumber() {
        return phoneNumber;
    }
 
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    /*addFieldError: 특정 필드에 대한 오류 메시지를 추가합니다.
     public void addFieldError(String fieldName, String errorMessage)
     
     		fieldName - 필드 이름
			errorMessage - 오류 메시지 */
    public void validate() {
        if (getUserName().length() == 0) {
            addFieldError("userName", "UserName is required");
        } 
          else if (!getUserName().equals("Sanjyot")) {
            addFieldError("userName", "Invalid User");
        }
       
        //getText: 메시지 키를 기준으로 메시지를 가져오거나 메시지를 찾을 수 없는 경우 제공된 키가 반환됩니다.
        if (getPassword().length() == 0) {
            addFieldError("password", getText("Password is required"));
        }
       
        if (getPhoneNumber().length() == 0) {
            addFieldError("phoneNumber", getText("Phone Number is required"));
        }
          else if (!(getPhoneNumber().length() == 10)) {
            addFieldError("phoneNumber", "Enter 10 digit phone number");
        }
        if (getEmail().length() == 0) {
            addFieldError("email", getText("Email is required"));
        }
         
    }
}
