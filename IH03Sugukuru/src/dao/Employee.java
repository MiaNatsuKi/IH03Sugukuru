package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.Common;
import entity.SsEmployee;

public class Employee {
	
	public List<SsEmployee> employeelist (ArrayList<ArrayList> list) {
		System.out.println("従業員リスト："+list);
		List<SsEmployee> datalist = null;
		SsEmployee entity = new SsEmployee();
		Common co = new Common();
		for(int size = 0; list.size() >= size; size++) {
			entity = new SsEmployee();
			entity.setEmployeeCode((String) list.get(size).get(0));
			entity.setPassword((String) list.get(size).get(1));
			entity.setName((String) list.get(size).get(2));
			entity.setFirstName((String) list.get(size).get(3));
			entity.setPostalCode((String) list.get(size).get(4));
			entity.setPurectures((String) list.get(size).get(5));
			entity.setCityName((String) list.get(size).get(6));
			entity.setTownName((String) list.get(size).get(7));
			entity.setAddress((String) list.get(size).get(8));
			entity.setBuildingName((String) list.get(size).get(9));
			entity.setPhoneNo((String) list.get(size).get(10));
			entity.setEmergencyContact((String) list.get(size).get(11));
			entity.setSex((int) co.parseIntegerforString((String) list.get(size).get(12)));
			entity.setPosition((int) co.parseIntegerforString((String) list.get(size).get(13)));
			entity.setRegisterDate((Date) co.parseDateforString((String) list.get(size).get(14)));
			entity.setTerminationDate((Date) co.parseDateforString((String) list.get(size).get(15)));
			entity.setTerminationFlg((int) co.parseIntegerforString((String) (list.get(size).get(16))));
			datalist.add(size, entity);
		}
		return datalist;
	}
}
