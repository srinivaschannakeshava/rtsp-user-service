package com.srini91.learn.rtsp.converter;

import javax.annotation.PostConstruct;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.srini91.learn.rtsp.dao.model.RtspUser;
import com.srini91.learn.rtsp.model.UserDTO;

@Component
public class UserDTOConverter implements Converter<RtspUser, UserDTO> {

//	private ModelMapper mapper;

	@Override
	public UserDTO convert(RtspUser source) {
		return UserDTO.builder().emailId(source.getEmailId())
				.cameraList(source.getCameraList())
				.cameraCount(source.getCameraList().size())
				.id(source.getId()).status(source.getStatus())
				.username(source.getUsername()).pwd(source.getPwd()).build();

//		return this.mapper.map(source, UserDTO.class);
	}

	@PostConstruct
	public void init() {
//		this.mapper=new ModelMapper();
//		TypeMap<RtspUser, UserDTO> propertyMapper = this.mapper.createTypeMap(RtspUser.class, UserDTO.class);
//	    org.modelmapper.Converter<Collection<?>, Integer> collectionToSize = c -> c.getSource().size();
//	    propertyMapper.addMappings(
//	      map -> map.using(collectionToSize).map(RtspUser::getCameraList, UserDTO::setCameraCount)
//	    );
//	    propertyMapper.addMapping(RtspUser::getCameraList, UserDTO::setCameraList);
//	    propertyMapper.addMapping(RtspUser::getCameraList, UserDTO::setCameraList);

	}

}
