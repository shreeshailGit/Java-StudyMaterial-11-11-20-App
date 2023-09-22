package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.model.IPLTeamInfo;
@Repository
public interface IIPLTeamRepository extends CrudRepository<IPLTeamInfo, Integer> {

}
