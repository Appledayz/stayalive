package com.stay.alive.accommodation.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.accommodation.mapper.AccommodationFileMapper;
import com.stay.alive.accommodation.mapper.AccommodationMapper;
import com.stay.alive.accommodation.vo.Accommodation;
import com.stay.alive.file.ImageFile;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AccommodationService {
	@Autowired
	private AccommodationMapper accommodationMapper;
	@Autowired
	private AccommodationFileMapper accommodationFileMapper;
	
	public ArrayList<Accommodation> getAccommodationListAll() {
		return nu
	}
	public String[] getAccommodationName(String memberId) {
		return accommodationMapper.selectAccommodationName(memberId);
	}
	public Accommodation getAccommodationInfo(String name) {
		return accommodationMapper.selectAccommodationInfo(name);
	}
	//숙소 리스트 
	public ArrayList<Accommodation> getAccommodationAll() {
		return accommodationMapper.selectAccommodationAll();
	}
	//숙소 수정
	public void modifyAccommodation(Accommodation accommodation, String path) {
		removeBusinessImageFile(accommodation.getImageFileNo());//기존에 있던 사업자 등록파일 삭제
		int newFileNo = addBusinessImageFiles(accommodation.getBusinessNumberFile(), path, accommodation.getMemberId());//새로운 사업자 등록 파일 추가
		accommodation.setImageFileNo(newFileNo); //새로 추가된  사업자 등록 번호 세팅 
		accommodationMapper.updateAccommodation(accommodation);
	}
	//숙소 추가
	public void addAccommodation(Accommodation accommodation, String path) {
		String sidoName = accommodation.getAddressSidoName();
		String sigunguName = accommodation.getAddressSigunguName();
		if(!accommodationMapper.selectSidoName(sidoName)) { //시도 이름이 데이터베이스에 없으면 추가
			accommodationMapper.insertSidoName(sidoName);
		}
		if(!accommodationMapper.selectSigunguName(sigunguName)) {//시군구 이름이 데이터베이스에 없으면 추가
			accommodationMapper.insertSigunguName(sigunguName);
		}
		
		int imageFileNo = addBusinessImageFiles(accommodation.getBusinessNumberFile(), path, accommodation.getMemberId());
		accommodation.setImageFileNo(imageFileNo); //사업자 등록증 파일번호 세팅
		int categoryNo = accommodation.getAccommodationCategoryNo();
		String categoryName = accommodationMapper.selectCategoryName(categoryNo); //카테고리 번호를통해 이름을 가져옴
		accommodation.setAccommodationCategoryName(categoryName); //카테고리 이름 데이터베이스에서 가져와서 세팅
		accommodationMapper.insertAccommodation(accommodation); //숙소 등록	
	}
	//사업자 등록 파일 삭제
	public void removeBusinessImageFile(int imageFileNo) {
		ImageFile imageFile = accommodationFileMapper.selectImageFile(imageFileNo);
		accommodationFileMapper.deleteImageFile(imageFileNo); //데이터베이스 -> 이미지파일 정보 삭제
		String path =imageFile.getImageFilePath();
		String ext = imageFile.getImageFileExt();
		String stordName = imageFile.getImageFileStoredName();
		File file = new File(path + "/" + stordName + "." + ext);
		System.out.println(path + "/" + stordName + "." + ext);
		file.delete(); //실제 저장된 파일 삭제
	}
	
	private String addImageFile(ImageFile imageFile, MultipartFile file, String path, String memberId, int fileRegisterTableNo, String registerTableName) {
		String storedFileName = "";
		String ext = "";
		if(!file.isEmpty()) {
			imageFile.setMemberId(memberId); //회원 id
			imageFile.setImageFilePath(path); //파일 전체 경로
			String realFileName = file.getOriginalFilename(); //파일 (이름 + 확장자)
			int index = realFileName.indexOf(".");
			String fileName = realFileName.substring(0,index); //파일 이름
			imageFile.setImageFileRealName(fileName);
			ext = realFileName.substring(fileName.length()+1, realFileName.length());// 확장자
			imageFile.setImageFileExt(ext);
			imageFile.setImageFileType(file.getContentType());
			imageFile.setImageFileSize(file.getSize() / 1024); //파일 크기(KB)
			storedFileName = UUID.randomUUID().toString(); //저장될 파일 이름(UUID)
			imageFile.setImageFileStoredName(storedFileName);
			imageFile.setFileRegisterTableNo(fileRegisterTableNo); //파일 테이블 번호(PK)
			imageFile.setFileRegisterTableName(registerTableName);
			File folder = new File (path); //폴더 생성을 위한 파일객체
			if(!folder.exists()) {
				folder.mkdirs();
			}
			File storedFile = new File(path + "/" + storedFileName + "." + ext); //실제 저장될 파일객체
			try {
				file.transferTo(storedFile);
			}
			catch(IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return "<img src=\"/image/accommodation/" + storedFileName + "." + ext + "\">";
	}
	
	public String addDetailImageFiles(MultipartFile[] multipartFile, String path, String memberId) {
		String imageTag = "";
		ImageFile imageFile = new ImageFile();
		imageFile.setMemberId(memberId); //임시로 회원아이디 세팅
		for(MultipartFile file: multipartFile) {
			if(!file.isEmpty()) {
				imageTag = imageTag + addImageFile(imageFile, file, path, memberId, 3, "숙소");
				accommodationFileMapper.insertImageFile(imageFile);
			}
		}
		return imageTag;
	}
	public int addBusinessImageFiles(MultipartFile file, String path, String memberId) {
		ImageFile imageFile = new ImageFile();
		addImageFile(imageFile, file, path, memberId, 6, "사업자등록");
		accommodationFileMapper.insertImageFile(imageFile);
		return imageFile.getImageFileNo();
	}
}
