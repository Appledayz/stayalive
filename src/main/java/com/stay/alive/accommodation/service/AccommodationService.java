package com.stay.alive.accommodation.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.accommodation.mapper.AccommodationFileMapper;
import com.stay.alive.accommodation.mapper.AccommodationMapper;
import com.stay.alive.accommodation.vo.Accommodation;
import com.stay.alive.file.ImageFile;

@Service
@Transactional
public class AccommodationService {
	@Autowired
	private AccommodationMapper accommodationMapper;
	@Autowired
	private AccommodationFileMapper accommodationFileMapper;
	
	public void addAccommodation(Accommodation accommodation, String path) {
		String sidoName = accommodation.getAddressSidoName();
		String sigunguName = accommodation.getAddressSigunguName();
		if(!accommodationMapper.selectSidoName(sidoName)) { //시도 이름이 데이터베이스에 없으면 추가
			accommodationMapper.insertSidoName(sigunguName);
		}
		if(!accommodationMapper.selectSigunguName(sigunguName)) {//시군구 이름이 데이터베이스에 없으면 추가
			accommodationMapper.insertSigunguName(sigunguName);
		}
		int categoryNo = accommodation.getAccommodationCategoryNo();
		String categoryName = accommodationMapper.selectCategoryName(categoryNo);
		accommodation.setAccommodationCategoryName(categoryName); //카테고리 이름 데이터베이스에서 가져와서 세팅
		
		System.out.println( categoryName + "<=== categoryName");
		accommodationMapper.insertAccommodation(accommodation);
		addBusinessImageFiles(accommodation.getBusinessNumberFile(), path, accommodation.getMemberId());
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
		return "<img src=\"/image/accommodation/" + storedFileName + "." + ext + "\"><br>";
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
	public void addBusinessImageFiles(MultipartFile file, String path, String memberId) {
		ImageFile imageFile = new ImageFile();
		addImageFile(imageFile, file, path, memberId, 6, "사업자등록");
		accommodationFileMapper.insertImageFile(imageFile);
	}
	public void test() {
		//System.out.println(accommodationMapper.selectSidoName("전북"));
		
	}
}
