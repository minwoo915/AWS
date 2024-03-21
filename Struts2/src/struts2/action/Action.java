package struts2.action;

import com.opensymphony.xwork2.ActionSupport;

import struts2.model.MessageVO;

public class Action extends ActionSupport {
	
	private MessageVO messageVO;
	
	public String excute() {
		messageVO = new MessageVO();
		
		return "success";
	}
	
	public MessageVO getMessageVO() {
		return messageVO;
	}
}
