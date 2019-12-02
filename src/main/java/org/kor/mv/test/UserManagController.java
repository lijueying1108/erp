package org.kor.mv.test;

import org.kor.mv.dto.BaseResponseMessage;
import org.kor.mv.dto.ResponseErrorMessage;
import org.kor.mv.dto.ResponseSuccessMessage;
import org.kor.mv.exception.PageInterviewException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserManagController {

	@RequestMapping(value="/query")
	@ResponseBody
	public BaseResponseMessage  queryUser(@RequestParam(value="userId") String userId) throws Exception {
		if (userId!=null) {
			ResponseSuccessMessage responseSuccessMessage = new ResponseSuccessMessage();
			responseSuccessMessage.setSuccessMsg("success");
			return responseSuccessMessage;
		} else {
			ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage();
			responseErrorMessage.setErrMsg("error");
			return responseErrorMessage;
		}
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public BaseResponseMessage  addUser(@RequestParam(value="userId") String userId) throws Exception {
		if (userId!=null) {
			ResponseSuccessMessage responseSuccessMessage = new ResponseSuccessMessage();
			responseSuccessMessage.setSuccessMsg("success");
			return responseSuccessMessage;
		} else {
			ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage();
			responseErrorMessage.setErrMsg("error");
			return responseErrorMessage;
		}
	}
	
	@RequestMapping(value="/edit/modify")
	@ResponseBody
	public BaseResponseMessage  modifyUser(@RequestParam(value="userId") String userId) throws Exception {
		if (userId!=null) {
			ResponseSuccessMessage responseSuccessMessage = new ResponseSuccessMessage();
			responseSuccessMessage.setSuccessMsg("success");
			return responseSuccessMessage;
		} else {
			ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage();
			responseErrorMessage.setErrMsg("error");
			return responseErrorMessage;
		}
	}
	
	@RequestMapping(value="/edit/delete")
	@ResponseBody
	public BaseResponseMessage  deleteUser(@RequestParam(value="userId") String userId) throws Exception {
		if (userId!=null) {
			ResponseSuccessMessage responseSuccessMessage = new ResponseSuccessMessage();
			responseSuccessMessage.setSuccessMsg("success");
			return responseSuccessMessage;
		} else {
			ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage();
			responseErrorMessage.setErrMsg("error");
			return responseErrorMessage;
		}
	}
}
