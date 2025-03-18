package in.ineuron.service;

import in.ineuron.dao.ICustomerDAO;

import in.ineuron.dto.CustomerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.*;
@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private ICustomerDAO dao;
	static {
		System.out.println("CustomerMgmtServiceImpl.class file is loading...");

	}
	public CustomerMgmtServiceImpl(ICustomerDAO dao) {
		System.out.println("CustomerMgmtServiceImpl::");
		this.dao = dao;
	}
	@Override
	public String calculateSimpleInterest(CustomerDTO dto) {
		float intrAmt=0.0f;
		String result=null;
		intrAmt=(dto.getPamt()*dto.getTime()*dto.getRate())/100.0f;
		CustomerBO bo=new CustomerBO();
		bo.setCustomerAddress(dto.getCustomerAddress());
		bo.setCustomerName(dto.getCustomerName());
		bo.setInterestAmt(intrAmt);
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		int count=dao.insert(bo);
		if(count>=1) {
			result="success";
		}else {
			result="Failed";
		}
		return result;
	}

}
