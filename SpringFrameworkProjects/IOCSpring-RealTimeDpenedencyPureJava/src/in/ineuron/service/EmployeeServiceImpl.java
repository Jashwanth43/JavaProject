package in.ineuron.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dto.EmployeeDTO;
import in.ineuron.bo.EmployeeBO;
import in.ineuron.dao.IEmployeeDao;
@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDao dao;
	@Override
	public String save(EmployeeDTO dto) {
		EmployeeBO bo = new EmployeeBO();
		bo.setEaddress(dto.getEaddress());
		bo.setEage(dto.getEage());
		bo.setEid(dto.getEid());
		bo.setEname(dto.getEname());
		return dao.save(bo);
	}

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		List<EmployeeBO> employeesBO = dao.findAllEmployees();
		List<EmployeeDTO> employeeDTO = new ArrayList<EmployeeDTO>();
		for (EmployeeBO bo : employeesBO) {

			EmployeeDTO dto = new EmployeeDTO();
			dto.setEid(bo.getEid());
			dto.setEname(bo.getEname());
			dto.setEage(bo.getEage());
			dto.setEaddress(bo.getEaddress());

			employeeDTO.add(dto);
		}
		return employeeDTO;
	}

	@Override
	public EmployeeDTO findById(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateByiId(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteByiId(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

}
