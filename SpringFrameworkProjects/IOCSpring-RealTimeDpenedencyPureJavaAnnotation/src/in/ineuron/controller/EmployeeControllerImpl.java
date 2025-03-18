package in.ineuron.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import in.ineuron.dto.EmployeeDTO;
import in.ineuron.service.IEmployeeService;
import in.ineuron.vo.EmployeeVO;
@Component("controller")
public class EmployeeControllerImpl implements IEmployeeController {
	@Autowired
	private IEmployeeService service;
	@Override
	public String save(EmployeeVO vo) {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setEaddress(vo.getEaddress());
		dto.setEage(Integer.parseInt(vo.getEage()));
		dto.setEname(vo.getEname());
		return service.save(dto);
		
	}

	@Override
	public List<EmployeeVO> findAllEmployees() {
		List<EmployeeDTO> employeeDTO=service.findAllEmployees();
		List<EmployeeVO> employeeVo=new ArrayList<EmployeeVO>();
		for (EmployeeDTO dto : employeeDTO) {
			EmployeeVO vo = new EmployeeVO();
			vo.setEname(dto.getEname());
			vo.setEage(String.valueOf(dto.getEage()));
			vo.setEaddress(dto.getEaddress());
			vo.setEid(String.valueOf(dto.getEid()));
			employeeVo.add(vo);
		}

		return employeeVo;
	}

	@Override
	public EmployeeVO findById(Integer eid) {
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
