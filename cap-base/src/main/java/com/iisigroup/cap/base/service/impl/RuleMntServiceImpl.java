/* 
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.DivRlItmDao;
import com.iisigroup.cap.base.model.DivRlItm;
import com.iisigroup.cap.base.service.RuleMntService;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.service.AbstractService;

/**
 * <pre>
 * Rule Maintain Service
 * </pre>
 * 
 * @since 2013/12/16
 * @author TimChiang
 * @version <ul>
 *          <li>2013/12/16,TimChiang,new
 *          </ul>
 */
@Service
public class RuleMntServiceImpl extends AbstractService implements
		RuleMntService {

	@Resource
	private DivRlItmDao dao;

	@Override
	public void saveDivRlItm(DivRlItm rlItm) {
		dao.save(rlItm);
	}

	@Override
	public Map<String, String> findByDivRlItmNos(String[] DivRlItmNos) {
		List<DivRlItm> ftList = dao.findByDivRlItmNo(DivRlItmNos);
		Map<String, String> m = new LinkedHashMap<String, String>();
		if (!ftList.isEmpty()) {
			for (DivRlItm c : ftList) {
				m.put(c.getDivRlNo(), c.getDivRlNm());
			}
		}
		return m;
	}

	@Override
	public DivRlItm findByDivRlItmNo(String DivRlItmNo) {
		return dao.findByDivRlItmNo(DivRlItmNo);
	}

	@Override
	public Map<String, Map<String, String>> findMapByRlItmNos(String[] nos) {
		List<DivRlItm> ftList = dao.findByDivRlItmNoAndInputFlg(nos, "1");
		Map<String, Map<String, String>> m = new LinkedHashMap<String, Map<String, String>>();
		if (!ftList.isEmpty()) {
			for (int i = 0; i < nos.length; i++) {
				Map<String, String> map = new LinkedHashMap<String, String>();
				for (DivRlItm c : ftList) {
					if (nos[i].equals(c.getDivRlNo())) {
						map.put(c.getDivRlNo(), c.getDivRlNm());
						m.put(nos[i], map);
					}
				}
			}
		}
		return m;
	}

	@Override
	public Map<String, AjaxFormResult> getDivRlItmsByNos(String[] nos) {
		List<DivRlItm> ftList = dao.findByDivRlItmNoAndInputFlg(nos, "1");
		Map<String, AjaxFormResult> m = new LinkedHashMap<String, AjaxFormResult>();
		if (!ftList.isEmpty()) {
			for (DivRlItm c : ftList) {
				String rlItmNo = c.getDivRlNo();
				AjaxFormResult sm = m.get(rlItmNo);
				if (sm == null) {
					sm = new AjaxFormResult();
				}
				sm.set(c.getDivRlNo(), c.getDivRlNm());
				m.put(rlItmNo, sm);
			}
		}
		return m;
	}

	@Override
	public DivRlItm getByRlItmNo(String rlItmNo) {
		return dao.findByDivRlItmNo(rlItmNo);
	}

	@Override
	public DivRlItm getById(String oid) {
		return dao.find(oid);
	}

	@Override
	public void deleteById(String oid) {
		DivRlItm rlItm = dao.find(oid);
		if (rlItm != null) {
			dao.delete(rlItm);
		}
	}
}
