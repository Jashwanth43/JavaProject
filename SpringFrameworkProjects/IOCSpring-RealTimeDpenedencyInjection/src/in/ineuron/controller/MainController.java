package in.ineuron.controller;

import in.ineuron.service.ICustomerMgmtService;
import in.ineuron.vo.CustomerVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import in.ineuron.dto.CustomerDTO;
@Controller("controller")
public class MainController {
	@Autowired
	private ICustomerMgmtService service;
static {
	System.out.println("MainController.class file is loading...");

}
	public MainController(ICustomerMgmtService service) {
		System.out.println("Main Controller: one param constructor...");
		this.service = service;
	}
	public String processResult(CustomerVo vo) {
		CustomerDTO dto=new CustomerDTO();
		dto.setCustomerName(vo.getCustomerName());
		dto.setCustomerAddress(vo.getCustomerAddress());
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		
		String result=service.calculateSimpleInterest(dto);
		return result;
		
	}
}
