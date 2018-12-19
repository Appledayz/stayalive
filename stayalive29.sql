-- --------------------------------------------------------
-- 호스트:                          stayalive29.cafe24.com
-- 서버 버전:                        10.1.13-MariaDB - MariaDB Server
-- 서버 OS:                        Linux
-- HeidiSQL 버전:                  9.5.0.5355
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 stayalive29.accommodation 구조 내보내기
CREATE TABLE IF NOT EXISTS `accommodation` (
  `accommodation_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '숙소 등록 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '회원아이디',
  `company_no` int(11) NOT NULL COMMENT '업체 등록 번호(FK)',
  `company_name` varchar(50) NOT NULL COMMENT '업체명',
  `accommodation_category_no` int(11) NOT NULL COMMENT '숙소 카테고리 번호(FK)',
  `accommodation_category_name` varchar(50) NOT NULL COMMENT '숙소 카테고리 명',
  `accommodation_name` varchar(50) NOT NULL COMMENT '숙소명',
  `accommodation_latitude` double NOT NULL COMMENT '숙소 위도',
  `accommodation_longitude` double NOT NULL COMMENT '숙소 경도',
  `address_sido_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '시/도',
  `address_sigungu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '시/군/구',
  `accommodation_address` varchar(50) NOT NULL COMMENT '숙소 주소',
  `member_business_number` varchar(50) NOT NULL COMMENT '사업자 번호',
  `accommodation_score` int(11) DEFAULT NULL COMMENT '평점',
  `accommodation_guestroom_total` int(11) DEFAULT NULL COMMENT '총 객실 수',
  `accommodation_phone` varchar(50) NOT NULL COMMENT '숙소 연락처',
  `accommodation_email` varchar(50) DEFAULT NULL COMMENT '숙소 이메일',
  `accommodation_detail` varchar(2000) DEFAULT NULL COMMENT '세부내용',
  `accommodation_register_date` datetime NOT NULL COMMENT '숙소 등록일자',
  `accommodation_update_date` datetime DEFAULT NULL COMMENT '마지막 숙소 등록정보 수정일',
  `image_file_no` int(11) DEFAULT NULL COMMENT '사업자 등록 파일',
  PRIMARY KEY (`accommodation_no`),
  KEY `FK_accommodation_accommodation_category` (`accommodation_category_no`),
  KEY `FK_accommodation_company` (`company_no`),
  KEY `member_id` (`member_id`),
  KEY `FK_accommodation_address_sido` (`address_sido_name`),
  KEY `FK_accommodation_address_sigungu` (`address_sigungu_name`),
  KEY `FK_accommodation_image_file` (`image_file_no`),
  CONSTRAINT `FK_accommodation_accommodation_category` FOREIGN KEY (`accommodation_category_no`) REFERENCES `accommodation_category` (`accommodation_category_no`),
  CONSTRAINT `FK_accommodation_address_sido` FOREIGN KEY (`address_sido_name`) REFERENCES `address_sido` (`address_sido_name`),
  CONSTRAINT `FK_accommodation_address_sigungu` FOREIGN KEY (`address_sigungu_name`) REFERENCES `address_sigungu` (`address_sigungu_name`),
  CONSTRAINT `FK_accommodation_company` FOREIGN KEY (`company_no`) REFERENCES `company` (`company_no`),
  CONSTRAINT `FK_accommodation_image_file` FOREIGN KEY (`image_file_no`) REFERENCES `image_file` (`image_file_no`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_accommodation_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='숙소';

-- 테이블 데이터 stayalive29.accommodation:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `accommodation` DISABLE KEYS */;
INSERT INTO `accommodation` (`accommodation_no`, `member_id`, `company_no`, `company_name`, `accommodation_category_no`, `accommodation_category_name`, `accommodation_name`, `accommodation_latitude`, `accommodation_longitude`, `address_sido_name`, `address_sigungu_name`, `accommodation_address`, `member_business_number`, `accommodation_score`, `accommodation_guestroom_total`, `accommodation_phone`, `accommodation_email`, `accommodation_detail`, `accommodation_register_date`, `accommodation_update_date`, `image_file_no`) VALUES
	(6, 'ID1', 9, 'stayalive', 1, '호텔', '1', 33.450701, 126.570667, '전북', '전주시 덕진구', '1', '1', 1, 1, '1', 'asd', '<h1>hello<h1>', '2018-12-12 00:00:00', '2018-12-17 09:03:56', 8),
	(8, 'ID1', 9, '여기어때', 3, '민박\r\n', '2', 35.85640723489145, 127.15621482988078, '전북', '전주시 덕진구', '전북 전주시 덕진구 견훤로 515', 'dd', NULL, NULL, 'qwe', 'qwe', '<p><br></p>', '2018-12-13 00:00:00', NULL, 8),
	(9, 'ID1', 20, '야놀자', 2, '모텔', '3', 35.85640723489145, 127.15621482988078, '전북', '전주시 덕진구', '', '', NULL, NULL, '', NULL, '<h1>hello world<h1>', '0000-00-00 00:00:00', NULL, NULL);
/*!40000 ALTER TABLE `accommodation` ENABLE KEYS */;

-- 테이블 stayalive29.accommodation_category 구조 내보내기
CREATE TABLE IF NOT EXISTS `accommodation_category` (
  `accommodation_category_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '숙소 카테고리 번호(PK)',
  `accommodation_category_name` varchar(50) NOT NULL COMMENT '숙소 카테고리명',
  `accommodation_category_registration_date` date NOT NULL COMMENT '숙소 카테고리 등록일',
  `accommodation_category_update_date` date DEFAULT NULL COMMENT '마지막 카테고리 등록정보 수정일',
  PRIMARY KEY (`accommodation_category_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='숙소 카테고리';

-- 테이블 데이터 stayalive29.accommodation_category:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `accommodation_category` DISABLE KEYS */;
INSERT INTO `accommodation_category` (`accommodation_category_no`, `accommodation_category_name`, `accommodation_category_registration_date`, `accommodation_category_update_date`) VALUES
	(1, '호텔\r\n', '2018-12-03', NULL),
	(2, '모텔', '2018-12-03', NULL),
	(3, '민박\r\n', '2018-12-03', NULL);
/*!40000 ALTER TABLE `accommodation_category` ENABLE KEYS */;

-- 테이블 stayalive29.address_sido 구조 내보내기
CREATE TABLE IF NOT EXISTS `address_sido` (
  `address_sido_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '도 번호(PK)',
  `address_sido_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '도 이름',
  `address_sido_date` date NOT NULL COMMENT '도 등록일',
  PRIMARY KEY (`address_sido_no`),
  UNIQUE KEY `address_sido_name` (`address_sido_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='주소 : 시/도';

-- 테이블 데이터 stayalive29.address_sido:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `address_sido` DISABLE KEYS */;
INSERT INTO `address_sido` (`address_sido_no`, `address_sido_name`, `address_sido_date`) VALUES
	(1, '전북', '2018-11-11'),
	(6, '서울', '2018-12-14'),
	(7, '강원', '2018-12-14');
/*!40000 ALTER TABLE `address_sido` ENABLE KEYS */;

-- 테이블 stayalive29.address_sigungu 구조 내보내기
CREATE TABLE IF NOT EXISTS `address_sigungu` (
  `address_sigungu_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '시 번호(PK)',
  `address_sigungu_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '시 이름',
  `address_sigungu_date` date NOT NULL COMMENT '시 등록일',
  PRIMARY KEY (`address_sigungu_no`),
  UNIQUE KEY `address_sigungu_name` (`address_sigungu_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='주소 : 시';

-- 테이블 데이터 stayalive29.address_sigungu:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `address_sigungu` DISABLE KEYS */;
INSERT INTO `address_sigungu` (`address_sigungu_no`, `address_sigungu_name`, `address_sigungu_date`) VALUES
	(1, '전주시 덕진구', '2018-12-13'),
	(7, '중랑구', '2018-12-14'),
	(8, '평창군', '2018-12-14');
/*!40000 ALTER TABLE `address_sigungu` ENABLE KEYS */;

-- 테이블 stayalive29.ad_cost 구조 내보내기
CREATE TABLE IF NOT EXISTS `ad_cost` (
  `ad_cost_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '광고 단가 번호(PK)',
  `ad_cost_type` varchar(50) NOT NULL COMMENT '광고 타입',
  `ad_cost_perday` int(11) DEFAULT NULL COMMENT '1일당 광고 단가',
  `ad_cost_size` varchar(50) NOT NULL COMMENT '광고 면적',
  PRIMARY KEY (`ad_cost_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='광고단가';

-- 테이블 데이터 stayalive29.ad_cost:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `ad_cost` DISABLE KEYS */;
INSERT INTO `ad_cost` (`ad_cost_no`, `ad_cost_type`, `ad_cost_perday`, `ad_cost_size`) VALUES
	(1, '플래시', 14000, '340X700'),
	(2, '플래시', 10000, '340X700'),
	(3, '이미지\r\n', 3000, '340X700');
/*!40000 ALTER TABLE `ad_cost` ENABLE KEYS */;

-- 테이블 stayalive29.ad_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `ad_file` (
  `ad_file_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '광고 파일 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '회원아이디',
  `ad_register_no` int(11) NOT NULL COMMENT '광고 등록 번호(FK)',
  `file_register_table_no` int(10) NOT NULL COMMENT '파일 등록 테이블 번호(FK)',
  `ad_file_path` varchar(50) NOT NULL COMMENT '파일경로',
  `ad_file_stored_name` varchar(50) NOT NULL COMMENT '저장된 파일 이름',
  `ad_file_real_name` varchar(50) NOT NULL COMMENT '파일 오리지널 이름',
  `ad_file_ext` varchar(50) NOT NULL COMMENT '파일확장자',
  `ad_file_type` varchar(50) NOT NULL COMMENT '파일형식',
  `ad_file_size` int(11) NOT NULL COMMENT '파일크기',
  `ad_file_date` date NOT NULL COMMENT '파일등록일',
  PRIMARY KEY (`ad_file_no`),
  KEY `ad_register_no` (`ad_register_no`),
  KEY `member_id` (`member_id`),
  KEY `file_register_table_no` (`file_register_table_no`),
  CONSTRAINT `FK_ad_file_ad_register` FOREIGN KEY (`ad_register_no`) REFERENCES `ad_register` (`ad_register_no`),
  CONSTRAINT `FK_ad_file_file_register_table` FOREIGN KEY (`file_register_table_no`) REFERENCES `file_register_table` (`file_register_table_no`),
  CONSTRAINT `FK_ad_file_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='광고 파일(관리자)';

-- 테이블 데이터 stayalive29.ad_file:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `ad_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `ad_file` ENABLE KEYS */;

-- 테이블 stayalive29.ad_group 구조 내보내기
CREATE TABLE IF NOT EXISTS `ad_group` (
  `ad_group_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '광고 그룹 번호(PK)',
  `ad_group_name` varchar(50) NOT NULL COMMENT '그룹명',
  `ad_group_date` date NOT NULL COMMENT '그룹 등록일자',
  `ad_group_cost` int(11) NOT NULL COMMENT '광고 위치 단가',
  PRIMARY KEY (`ad_group_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='광고 그룹(관리자)';

-- 테이블 데이터 stayalive29.ad_group:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `ad_group` DISABLE KEYS */;
INSERT INTO `ad_group` (`ad_group_no`, `ad_group_name`, `ad_group_date`, `ad_group_cost`) VALUES
	(1, '메인스크롤 배너', '2018-11-19', 10000),
	(2, '메인 상단\r\n', '2018-11-20', 2000),
	(3, '메인 하단', '2018-11-21', 2000);
/*!40000 ALTER TABLE `ad_group` ENABLE KEYS */;

-- 테이블 stayalive29.ad_refund 구조 내보내기
CREATE TABLE IF NOT EXISTS `ad_refund` (
  `ad_refund_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '광고 환불 번호(PK)',
  `ad_no` int(11) NOT NULL COMMENT '광고 번호(FK)',
  `ad_refund_application_date` date NOT NULL COMMENT '환불 신청일',
  `advertisement_refund_state` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '환불 상태',
  PRIMARY KEY (`ad_refund_no`),
  KEY `FK_advertisement_refund_advertisement` (`ad_no`),
  CONSTRAINT `FK_ad_no` FOREIGN KEY (`ad_no`) REFERENCES `ad_register` (`ad_register_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='광고 환불';

-- 테이블 데이터 stayalive29.ad_refund:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `ad_refund` DISABLE KEYS */;
/*!40000 ALTER TABLE `ad_refund` ENABLE KEYS */;

-- 테이블 stayalive29.ad_register 구조 내보내기
CREATE TABLE IF NOT EXISTS `ad_register` (
  `ad_register_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '광고 등록 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '회원아이디',
  `ad_register_date` date DEFAULT NULL COMMENT '광고 신청일',
  `ad_register_confirm` date DEFAULT NULL COMMENT '광고 승인일',
  `ad_cost_no` int(11) NOT NULL COMMENT '광고 단가 번호(FK)',
  `ad_register_start` date DEFAULT NULL COMMENT '시작시간',
  `ad_register_end` date DEFAULT NULL COMMENT '마감시간',
  `ad_register_post` enum('Y','N') NOT NULL DEFAULT 'N' COMMENT '광고 게시 유무',
  `ad_group_no` int(11) NOT NULL COMMENT '광고 그룹 번호(FK)',
  `ad_register_link` varchar(50) DEFAULT NULL COMMENT '광고링크',
  `ad_register_view` int(11) DEFAULT NULL COMMENT '노출수',
  `ad_register_click` int(11) DEFAULT NULL COMMENT '클릭수',
  `ad_update_date` date DEFAULT NULL COMMENT '광고 수정일',
  PRIMARY KEY (`ad_register_no`),
  KEY `ad_group_no` (`ad_group_no`),
  KEY `ad_cost_no` (`ad_cost_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `FK_ad_register_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `ad_cost_no` FOREIGN KEY (`ad_cost_no`) REFERENCES `ad_cost` (`ad_cost_no`),
  CONSTRAINT `ad_group_no` FOREIGN KEY (`ad_group_no`) REFERENCES `ad_group` (`ad_group_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='광고 등록(판매자)';

-- 테이블 데이터 stayalive29.ad_register:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `ad_register` DISABLE KEYS */;
INSERT INTO `ad_register` (`ad_register_no`, `member_id`, `ad_register_date`, `ad_register_confirm`, `ad_cost_no`, `ad_register_start`, `ad_register_end`, `ad_register_post`, `ad_group_no`, `ad_register_link`, `ad_register_view`, `ad_register_click`, `ad_update_date`) VALUES
	(1, 'ID1', '2018-12-11', '2018-12-11', 1, '2018-12-19', '2018-12-20', 'N', 2, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `ad_register` ENABLE KEYS */;

-- 테이블 stayalive29.auction_state_category 구조 내보내기
CREATE TABLE IF NOT EXISTS `auction_state_category` (
  `auction_state_category_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '경매 상태 카테고리 번호(PK)',
  `auction_state_category_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '상태 카테고리명',
  `auction_state_category_date` date NOT NULL COMMENT '상테 카테고리 등록일',
  PRIMARY KEY (`auction_state_category_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='경매 상태 카테고리';

-- 테이블 데이터 stayalive29.auction_state_category:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `auction_state_category` DISABLE KEYS */;
INSERT INTO `auction_state_category` (`auction_state_category_no`, `auction_state_category_name`, `auction_state_category_date`) VALUES
	(1, '낙찰대기중\r\n', '2018-11-19'),
	(2, '낙찰완료\r\n', '2018-11-20'),
	(3, '결제완료\r\n', '2018-11-21');
/*!40000 ALTER TABLE `auction_state_category` ENABLE KEYS */;

-- 테이블 stayalive29.board_admin 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_admin` (
  `board_admin_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '관리자 게시글번호(PK)',
  `board_category_no` int(11) NOT NULL COMMENT '게시판 카테고리 번호(FK)',
  `board_category_name` varchar(50) DEFAULT NULL COMMENT '카테고리명(게시판명)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '관리자아이디',
  `group_no` varchar(50) DEFAULT NULL COMMENT '회원 그룹 번호(FK)',
  `group_name` varchar(50) DEFAULT NULL COMMENT '그룹명',
  `board_admin_title` varchar(50) DEFAULT NULL COMMENT '제목',
  `board_admin_content` varchar(50) DEFAULT NULL COMMENT '내용',
  `board_admin_register_date` date DEFAULT NULL COMMENT '게시글 등록일자',
  `board_admin_hits` int(11) DEFAULT NULL COMMENT '조회수',
  `board_member_recommend` int(11) DEFAULT NULL COMMENT '추천',
  `board_member_file` int(11) DEFAULT NULL COMMENT '파일',
  `board_member_modify_date` date DEFAULT NULL COMMENT '게시글 마지막 수정일자',
  `board_state_no` int(11) NOT NULL COMMENT '게시판 상태 번호(FK)',
  `board_state_name` varchar(50) DEFAULT NULL COMMENT '상태명',
  PRIMARY KEY (`board_admin_no`),
  KEY `admin_category_no` (`board_category_no`),
  KEY `admin_state_no` (`board_state_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `FK_board_admin_board_state` FOREIGN KEY (`board_state_no`) REFERENCES `board_state` (`board_state_no`),
  CONSTRAINT `FK_board_admin_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `admin_category_no` FOREIGN KEY (`board_category_no`) REFERENCES `board_category` (`board_category_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시판(관리자)';

-- 테이블 데이터 stayalive29.board_admin:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `board_admin` ENABLE KEYS */;

-- 테이블 stayalive29.board_category 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_category` (
  `board_category_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '게시판 카테고리 번호(PK)',
  `board_category_name` varchar(50) NOT NULL COMMENT '카테고리명(게시판명)',
  `board_category_date` date NOT NULL COMMENT '카테고리 등록일',
  PRIMARY KEY (`board_category_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='게시판(카테고리) ';

-- 테이블 데이터 stayalive29.board_category:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board_category` DISABLE KEYS */;
INSERT INTO `board_category` (`board_category_no`, `board_category_name`, `board_category_date`) VALUES
	(1, '자유게시판', '2018-12-03'),
	(2, '포토갤러리', '2018-12-03'),
	(3, '공지사항', '2018-12-03');
/*!40000 ALTER TABLE `board_category` ENABLE KEYS */;

-- 테이블 stayalive29.board_member 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_member` (
  `board_member_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '회원 게시글번호(PK)',
  `board_category_no` int(11) NOT NULL COMMENT '게시판 카테고리 번호(FK)',
  `board_category_name` varchar(50) NOT NULL COMMENT '카테고리명(게시판명)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '회원아이디',
  `group_no` int(11) NOT NULL COMMENT '회원 그룹 번호(FK)',
  `group_name` varchar(50) NOT NULL COMMENT '그룹명',
  `board_member_title` varchar(50) NOT NULL COMMENT '제목',
  `board_member_content` varchar(50) DEFAULT NULL COMMENT '내용',
  `board_member_secret` enum('Y','N') NOT NULL DEFAULT 'N' COMMENT '비밀글',
  `board_member_register_date` date NOT NULL COMMENT '게시글 등록일자',
  `board_member_hits` int(11) unsigned zerofill DEFAULT NULL COMMENT '조회수',
  `board_member_recommend` int(11) unsigned zerofill DEFAULT NULL COMMENT '추천',
  `board_member_reply` int(11) unsigned zerofill DEFAULT NULL COMMENT '댓글',
  `board_member_file` int(11) DEFAULT NULL COMMENT '파일',
  `board_member_modify_date` date DEFAULT NULL COMMENT '게시글 마지막 수정일자',
  `board_state_no` int(11) NOT NULL COMMENT '게시판 상태 번호(FK)',
  `board_state_name` varchar(50) DEFAULT NULL COMMENT '상태명',
  PRIMARY KEY (`board_member_no`),
  KEY `member_category_no` (`board_category_no`),
  KEY `member_state_no` (`board_state_no`),
  KEY `group_no` (`group_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `FK_board_member_board_category` FOREIGN KEY (`board_category_no`) REFERENCES `board_category` (`board_category_no`),
  CONSTRAINT `FK_board_member_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK_board_member_member_group` FOREIGN KEY (`group_no`) REFERENCES `member_group` (`group_no`),
  CONSTRAINT `member_state_no` FOREIGN KEY (`board_state_no`) REFERENCES `board_state` (`board_state_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시판(회원)';

-- 테이블 데이터 stayalive29.board_member:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `board_member` ENABLE KEYS */;

-- 테이블 stayalive29.board_nonmember 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_nonmember` (
  `board_nonmember_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '비회원 게시글번호(PK)',
  `board_category_no` int(11) NOT NULL COMMENT '게시판 카테고리 번호',
  `board_category_name` varchar(50) NOT NULL COMMENT '카테고리명(게시판명)',
  `board_nonmember_password` varchar(50) NOT NULL COMMENT '게시글 패스워드',
  `board_nonmember_title` varchar(50) NOT NULL COMMENT '제목',
  `board_nonmember_content` varchar(50) DEFAULT NULL COMMENT '내용',
  `board_nonmember_ip` varchar(50) NOT NULL COMMENT 'IP주소',
  `board_nonmember_register_date` date NOT NULL COMMENT '게시글 등록일자',
  `board_nonmember_hits` int(11) unsigned zerofill DEFAULT NULL COMMENT '조회수',
  `board_nonmember_recommend` int(11) unsigned zerofill DEFAULT NULL COMMENT '추천',
  `board_nonmember_reply` varchar(50) DEFAULT NULL COMMENT '댓글',
  `board_nonmember_file` int(11) DEFAULT NULL COMMENT '파일',
  `board_nonmember_modify_date` date DEFAULT NULL COMMENT '게시글 마지막 수정일자',
  `board_state_no` int(11) NOT NULL COMMENT '게시판 상태 번호(FK)',
  `board_state_name` varchar(50) DEFAULT NULL COMMENT '상태명',
  PRIMARY KEY (`board_nonmember_no`),
  KEY `nonmember_category_no` (`board_category_no`),
  KEY `nonmember_state_no` (`board_state_no`),
  CONSTRAINT `FK_board_nonmember_board_category` FOREIGN KEY (`board_category_no`) REFERENCES `board_category` (`board_category_no`),
  CONSTRAINT `FK_board_nonmember_board_state` FOREIGN KEY (`board_state_no`) REFERENCES `board_state` (`board_state_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시판(비회원)';

-- 테이블 데이터 stayalive29.board_nonmember:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board_nonmember` DISABLE KEYS */;
/*!40000 ALTER TABLE `board_nonmember` ENABLE KEYS */;

-- 테이블 stayalive29.board_reply 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_reply` (
  `board_reply_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '게시판 댓글 번호(PK)',
  `group_no` int(11) NOT NULL COMMENT '회원 그룹 번호(FK)',
  `group_name` varchar(50) DEFAULT NULL COMMENT '그룹명',
  `board_no` int(11) DEFAULT NULL COMMENT '각 게시판 게시글번호',
  `board_category_no` int(11) NOT NULL COMMENT '게시글 카테고리 번호',
  `board_reply_ip` varchar(50) DEFAULT NULL COMMENT 'IP주소',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin COMMENT '회원 아이디',
  `board_reply_content` varchar(50) DEFAULT NULL COMMENT '내용',
  `board_reply_secret` enum('Y','N') NOT NULL DEFAULT 'N' COMMENT '비밀댓글',
  `board_reply_date` date NOT NULL COMMENT '댓글단 날짜',
  PRIMARY KEY (`board_reply_no`),
  KEY `reply_group_no` (`group_no`),
  KEY `board_category_no` (`board_category_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `FK_board_reply_board_category` FOREIGN KEY (`board_category_no`) REFERENCES `board_category` (`board_category_no`),
  CONSTRAINT `FK_board_reply_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK_board_reply_member_group` FOREIGN KEY (`group_no`) REFERENCES `member_group` (`group_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시판(댓글)';

-- 테이블 데이터 stayalive29.board_reply:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `board_reply` ENABLE KEYS */;

-- 테이블 stayalive29.board_state 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_state` (
  `board_state_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '게시판 상태 번호(PK)',
  `board_state_name` varchar(50) NOT NULL COMMENT '상태명',
  `board_state_date` date NOT NULL COMMENT '상태 등록일자',
  PRIMARY KEY (`board_state_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='게시판 상태(카테고리)';

-- 테이블 데이터 stayalive29.board_state:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board_state` DISABLE KEYS */;
INSERT INTO `board_state` (`board_state_no`, `board_state_name`, `board_state_date`) VALUES
	(1, '일반', '2018-12-03'),
	(2, '신고', '2018-12-03'),
	(3, '문의대기', '2018-12-03');
/*!40000 ALTER TABLE `board_state` ENABLE KEYS */;

-- 테이블 stayalive29.company 구조 내보내기
CREATE TABLE IF NOT EXISTS `company` (
  `company_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '업체 등록 번호(PK)',
  `company_name` varchar(50) DEFAULT NULL COMMENT '업체명',
  `company_homepage` varchar(50) DEFAULT NULL COMMENT '업체 홈페이지',
  `company_address` varchar(100) DEFAULT NULL COMMENT '업체 주소',
  `company_email` varchar(100) DEFAULT NULL COMMENT '업체 이메일',
  `company_detail` varchar(100) DEFAULT NULL COMMENT '업체 상세정보',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '숙박 업체 회원 아이디',
  `rating_no` int(11) COMMENT '회원 등급 번호(FK)',
  `rating_name` varchar(50) DEFAULT NULL COMMENT '등급명',
  `company_volume` int(11) unsigned DEFAULT '0' COMMENT '업체 거래량',
  `member_option_no` int(11) COMMENT '회원옵션번호(FK)',
  `member_option_name` varchar(50) DEFAULT NULL COMMENT '옵션명',
  `register_salespost_total` int(11) unsigned DEFAULT '0' COMMENT '등록한 판매 게시물 수',
  `register_accommodation_count` int(11) unsigned DEFAULT '0' COMMENT '등록한 숙박시설 수',
  `reverseauction_register_count` int(11) unsigned DEFAULT '0' COMMENT '현재 역경매 입찰 현황(역경매 등록현황)',
  `reverseauction_successfulbid_count` int(11) unsigned DEFAULT '0' COMMENT '역경매 낙찰횟수',
  `dutchauction_register_count` int(11) unsigned DEFAULT '0' COMMENT '네덜란드식 경매 등록 현황',
  `dutchauction_sales_count` int(11) unsigned DEFAULT '0' COMMENT '네덜란드식 경매 통한 판매량',
  `company_wishlist_count` int(11) unsigned DEFAULT '0' COMMENT '찜한 사람수',
  `company_recognition` enum('Y','N') DEFAULT 'N' COMMENT '업체 승인 유무',
  `company_register_date` date DEFAULT NULL COMMENT '업체 등록일자',
  `company_update_date` date DEFAULT NULL COMMENT '마지막 업체 등록정보 수정일',
  PRIMARY KEY (`company_no`),
  KEY `FK_company_member_rating` (`rating_no`),
  KEY `FK_company_member_option` (`member_option_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `FK_company_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK_company_member_option` FOREIGN KEY (`member_option_no`) REFERENCES `member_option` (`member_option_no`),
  CONSTRAINT `FK_company_member_rating` FOREIGN KEY (`rating_no`) REFERENCES `member_rating` (`rating_no`)
) ENGINE=InnoDB AUTO_INCREMENT=389 DEFAULT CHARSET=utf8 CHECKSUM=1 COMMENT='업체';

-- 테이블 데이터 stayalive29.company:~378 rows (대략적) 내보내기
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`company_no`, `company_name`, `company_homepage`, `company_address`, `company_email`, `company_detail`, `member_id`, `rating_no`, `rating_name`, `company_volume`, `member_option_no`, `member_option_name`, `register_salespost_total`, `register_accommodation_count`, `reverseauction_register_count`, `reverseauction_successfulbid_count`, `dutchauction_register_count`, `dutchauction_sales_count`, `company_wishlist_count`, `company_recognition`, `company_register_date`, `company_update_date`) VALUES
	(9, '0', '0', '0', '', '', 'ID1', 4, 'vvip', 1, 1, '프리미엄1', 1, 1, 1, 1, 1, 1, 1, 'N', '2018-12-12', NULL),
	(11, '1', '1', '1', '1', '', 'id011', 1, '123', 0, 2, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-13', NULL),
	(12, '2', '2', '2', '2@2', '2', 'id011', 1, '123', 0, 2, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-13', NULL),
	(13, '', '', '', '', '', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-13', NULL),
	(14, 'rergdfg', '123', '123', 'asdf@masdf', 'sdfg', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-13', NULL),
	(15, '3', '3', '3', '3@3', '3', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-14', NULL),
	(16, '4', '4', '4', '4@4', '4', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-14', NULL),
	(17, '5', '5', '5', '5@5', '5', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-14', NULL),
	(18, '6', '6', '6', '6@6', '6', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-14', NULL),
	(19, '7', '7', '7', '7@7', '7', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-14', NULL),
	(20, '8', '8', '8', '8@8', '8', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-14', NULL),
	(22, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(23, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(24, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(25, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(26, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(27, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(28, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(29, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(30, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(31, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(32, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(33, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(34, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(35, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(36, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(37, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(38, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(39, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(40, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(41, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(42, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(43, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(44, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(45, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(46, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(47, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(48, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(49, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(50, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(51, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(52, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(53, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(54, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(55, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(56, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(57, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(58, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(59, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(60, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(61, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(62, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(63, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(64, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(65, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(66, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(67, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(68, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(69, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(70, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(71, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(72, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(73, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(74, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(75, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(76, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(77, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(78, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(79, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(80, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(81, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(82, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(83, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(84, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(85, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(86, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(87, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(88, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(89, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(90, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(91, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(92, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(93, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(94, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(95, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(96, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(97, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(98, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(99, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(100, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(101, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(102, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(103, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(104, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(105, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(106, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(107, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(108, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(109, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(110, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(111, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(112, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(113, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(114, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(115, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(116, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(117, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(118, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(119, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(120, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(121, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(122, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(123, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(124, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(125, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(126, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(127, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(128, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(129, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(130, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(131, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(132, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(133, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(134, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(135, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(136, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(137, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(138, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(139, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(140, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(141, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(142, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(143, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(144, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(145, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(146, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(147, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(148, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(149, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(150, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(151, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(152, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(153, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(154, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(155, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(156, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(157, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(158, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(159, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(160, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(161, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(162, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(163, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(164, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(165, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(166, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(167, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(168, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(169, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(170, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(171, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(172, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(173, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(174, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(175, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(176, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(177, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(178, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(179, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(180, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(181, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(182, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(183, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(184, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(185, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(186, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(187, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(188, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(189, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(190, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(191, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(192, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(193, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(194, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(195, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(196, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(197, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(198, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(199, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(200, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(201, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(202, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(203, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(204, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(205, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(206, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(207, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(208, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(209, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(210, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(211, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(212, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(213, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(214, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(215, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(216, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(217, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(218, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(219, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(220, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(221, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(222, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(223, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(224, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(225, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(226, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(227, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(228, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(229, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(230, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(231, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(232, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(233, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(234, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(235, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(236, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(237, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(238, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(239, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(240, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(241, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(242, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(243, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(244, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(245, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(246, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(247, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(248, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(249, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(250, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(251, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(252, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(253, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(254, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(255, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(256, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(257, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(258, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(259, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(260, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(261, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(262, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(263, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(264, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(265, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(266, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(267, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(268, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(269, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(270, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(271, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(272, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(273, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(274, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(275, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(276, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(277, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(278, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(279, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(280, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(281, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(282, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(283, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(284, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(285, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(286, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(287, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(288, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(289, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(290, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(291, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(292, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(293, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(294, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(295, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(296, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(297, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(298, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(299, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(300, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(301, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(302, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(303, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(304, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(305, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(306, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(307, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(308, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(309, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(310, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(311, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(312, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(313, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(314, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(315, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(316, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(317, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(318, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(319, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(320, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(321, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(322, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(323, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(324, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(325, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(326, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(327, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(328, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(329, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(330, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(331, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(332, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(333, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(334, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(335, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(336, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(337, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(338, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(339, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(340, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(341, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(342, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(343, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(344, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(345, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(346, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(347, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(348, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(349, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(350, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(351, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(352, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(353, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(354, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(355, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(356, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(357, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(358, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(359, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(360, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(361, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(362, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(363, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(364, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(365, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(366, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(367, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(368, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(369, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(370, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(371, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(372, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(373, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(374, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(375, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(376, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(377, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(378, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(379, NULL, NULL, NULL, NULL, NULL, 'id011', 1, NULL, 0, 1, NULL, 0, 0, 0, 0, 0, 0, 0, 'N', NULL, NULL),
	(380, '', '', '', '', '', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-14', NULL),
	(381, '', '', '', '', '', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-14', NULL),
	(382, 'rergdfg', '123', '123', 'asdf@masdf', '1414', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-14', NULL),
	(383, '', '', '', '', '', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-17', NULL),
	(384, '', '', '', '', '', 'id011', 1, '123', 0, 2, '프리미엄2', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-17', NULL),
	(385, '1', '2', '3', '4@4', '5', 'ID1', 1, '', 0, 1, '', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-18', NULL),
	(386, '', '', '', '', '', 'ID1', 1, '', 0, 1, '', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-19', NULL),
	(387, '', '', '', '', '', 'ID1', 1, '', 0, 1, '', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-19', NULL),
	(388, 'stayalive', 'stayalive.com', '전주시', 'stayalive@naver.com', 'stayalive로 숙소를 싸게 구하자', 'ID1', 1, '', 0, 1, '', 0, 0, 0, 0, 0, 0, 0, 'N', '2018-12-19', NULL);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;

-- 테이블 stayalive29.dutchauction_register 구조 내보내기
CREATE TABLE IF NOT EXISTS `dutchauction_register` (
  `dutchauction_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '네덜란드식 경매 등록 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원 아이디',
  `company_no` int(10) NOT NULL COMMENT '업체 등록번호(FK)',
  `company_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '업체명',
  `accommodation_no` int(10) NOT NULL COMMENT '숙소 등록번호(FK)',
  `accommodation_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '숙소명',
  `guestroom_no` int(10) NOT NULL COMMENT '객실 등록번호(FK)',
  `guestroom_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '객실명',
  `dutchauction_register_date` datetime NOT NULL COMMENT '등록일',
  `dutchauction_startprice` int(10) NOT NULL COMMENT '경매 시작가',
  `accommodation_guestroom_allcount` int(10) DEFAULT NULL COMMENT '총 객실 수',
  `guestroom_state_count` int(10) DEFAULT NULL COMMENT '빈 객실 수',
  `maximum_discount_price` int(10) NOT NULL COMMENT '최대 할인가',
  `dutchauction_xpersale` int(10) NOT NULL COMMENT 'x 시간당 할인가',
  `dutchauction_xvalue` int(10) NOT NULL COMMENT 'x 값',
  `dutchauction_curent_price` int(10) NOT NULL COMMENT '현재가',
  `dutchauction_update_price` int(11) DEFAULT NULL COMMENT '마지막 가격 변동 시간(일자)',
  `dutchauction_close_date` datetime NOT NULL COMMENT '경매 종료일',
  `dutchauction_rooming_date` datetime DEFAULT NULL COMMENT '숙소 입실일',
  `dutchauction_leaving_date` datetime DEFAULT NULL COMMENT '숙소 퇴실일',
  `auction_state_category_no` int(10) NOT NULL COMMENT '경매 상태 카테고리 번호(FK)',
  `auction_state_category_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '상태 카테고리명',
  PRIMARY KEY (`dutchauction_no`),
  KEY `FK_dutchauction_register_company` (`company_no`),
  KEY `FK_dutchauction_register_accommodation` (`accommodation_no`),
  KEY `FK_dutchauction_register_guestroom` (`guestroom_no`),
  KEY `FK_dutchauction_register_auction_state_category` (`auction_state_category_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `FK_dutchauction_register_accommodation` FOREIGN KEY (`accommodation_no`) REFERENCES `accommodation` (`accommodation_no`),
  CONSTRAINT `FK_dutchauction_register_auction_state_category` FOREIGN KEY (`auction_state_category_no`) REFERENCES `auction_state_category` (`auction_state_category_no`),
  CONSTRAINT `FK_dutchauction_register_company` FOREIGN KEY (`company_no`) REFERENCES `company` (`company_no`),
  CONSTRAINT `FK_dutchauction_register_guestroom` FOREIGN KEY (`guestroom_no`) REFERENCES `guestroom` (`guestroom_no`),
  CONSTRAINT `FK_dutchauction_register_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='네덜란드식 경매 등록';

-- 테이블 데이터 stayalive29.dutchauction_register:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `dutchauction_register` DISABLE KEYS */;
/*!40000 ALTER TABLE `dutchauction_register` ENABLE KEYS */;

-- 테이블 stayalive29.dutchauction_successfulbid 구조 내보내기
CREATE TABLE IF NOT EXISTS `dutchauction_successfulbid` (
  `dutchauction_successfulbid_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '네덜란드식 경매 낙찰번호(PK)',
  `dutchauction_register_no` int(11) NOT NULL COMMENT '네덜란드식 경매 등록번호(FK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원 아이디',
  `dutchauction_successfulbid_price` int(10) DEFAULT NULL COMMENT '낙찰가',
  `dutchauction_successfulbid_date` date DEFAULT NULL COMMENT '낙찰일',
  `dutchauction_rooming_date` date DEFAULT NULL COMMENT '숙소 입실일',
  `dutchauction_leaving_date` date DEFAULT NULL COMMENT '숙소 퇴실일',
  `guestroom_option_no` int(10) NOT NULL COMMENT '객실 옵션 등록 번호(FK)',
  `guestroom_option_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '옵션명',
  `guestroom_additional_price` int(10) DEFAULT NULL COMMENT '추가 가격/1박',
  `auction_state_category_no` int(10) NOT NULL COMMENT '상태 카테고리 번호(FK)',
  `auction_state_category_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '상태 카테고리명',
  PRIMARY KEY (`dutchauction_successfulbid_no`),
  KEY `FK_dutchauction_successfulbid_dutchauction_register` (`dutchauction_register_no`),
  KEY `FK_dutchauction_successfulbid_auction_state_category` (`auction_state_category_no`),
  KEY `FK_dutchauction_successfulbid_guestroom_option` (`guestroom_option_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `FK_dutchauction_successfulbid_auction_state_category` FOREIGN KEY (`auction_state_category_no`) REFERENCES `auction_state_category` (`auction_state_category_no`),
  CONSTRAINT `FK_dutchauction_successfulbid_dutchauction_register` FOREIGN KEY (`dutchauction_register_no`) REFERENCES `dutchauction_register` (`dutchauction_no`),
  CONSTRAINT `FK_dutchauction_successfulbid_guestroom_option` FOREIGN KEY (`guestroom_option_no`) REFERENCES `guestroom_option` (`guestroom_option_no`),
  CONSTRAINT `FK_dutchauction_successfulbid_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='네덜란드식 경매 낙찰';

-- 테이블 데이터 stayalive29.dutchauction_successfulbid:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `dutchauction_successfulbid` DISABLE KEYS */;
/*!40000 ALTER TABLE `dutchauction_successfulbid` ENABLE KEYS */;

-- 테이블 stayalive29.file 구조 내보내기
CREATE TABLE IF NOT EXISTS `file` (
  `file_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '파일 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원 아이디',
  `file_register_table_no` int(10) NOT NULL COMMENT '파일 등록 테이블 번호(FK)',
  `file_register_table_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '테이블명',
  `file_path` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '파일 경로',
  `file_stored_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '저장된 파일 이름',
  `file_real_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '파일 이름',
  `file_ext` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '파일 확장자',
  `file_type` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '파일 형식',
  `file_size` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '파일 크기',
  `file_register_date` date NOT NULL COMMENT '파일 등록일',
  PRIMARY KEY (`file_no`),
  KEY `FK_file_file_register_table` (`file_register_table_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `FK_file_file_register_table` FOREIGN KEY (`file_register_table_no`) REFERENCES `file_register_table` (`file_register_table_no`),
  CONSTRAINT `FK_file_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='파일';

-- 테이블 데이터 stayalive29.file:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;

-- 테이블 stayalive29.file_register_table 구조 내보내기
CREATE TABLE IF NOT EXISTS `file_register_table` (
  `file_register_table_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '파일 등록 테이블 번호(PK)',
  `file_register_table_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '테이블명',
  `file_register_table_date` date NOT NULL COMMENT '테이블 등록일자',
  PRIMARY KEY (`file_register_table_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='파일 등록 테이블';

-- 테이블 데이터 stayalive29.file_register_table:~6 rows (대략적) 내보내기
/*!40000 ALTER TABLE `file_register_table` DISABLE KEYS */;
INSERT INTO `file_register_table` (`file_register_table_no`, `file_register_table_name`, `file_register_table_date`) VALUES
	(1, '역경매', '2018-12-10'),
	(2, '게시판', '2018-12-10'),
	(3, '숙소', '2018-12-10'),
	(4, '업체', '2018-12-10'),
	(5, '광고', '2018-12-11'),
	(6, '사업자등록', '2018-12-13');
/*!40000 ALTER TABLE `file_register_table` ENABLE KEYS */;

-- 테이블 stayalive29.guestroom 구조 내보내기
CREATE TABLE IF NOT EXISTS `guestroom` (
  `guestroom_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '객실 등록 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '숙박 업체 회원 아이디',
  `company_no` int(11) NOT NULL COMMENT '업체 등록 번호(FK)',
  `company_name` varchar(50) NOT NULL COMMENT '업체명',
  `accommodation_no` int(11) NOT NULL COMMENT '숙소 등록 번호(FK)',
  `accommodation_name` varchar(50) NOT NULL COMMENT '숙소명',
  `guestroom_name` varchar(50) NOT NULL COMMENT '객실명',
  `guestroom_image_count` int(10) unsigned zerofill DEFAULT NULL COMMENT '객실 이미지 개수',
  `guestroom_buy_instant` int(11) NOT NULL COMMENT '즉시구매가(1박기준)',
  `guestroom_capacity` int(11) NOT NULL COMMENT '수용인원',
  `guestroom_capacity_max` int(11) NOT NULL COMMENT '최대 수용인원',
  `guestroom_additional_perprice` int(10) unsigned zerofill DEFAULT NULL COMMENT '추가인원당 가격',
  `guestroom_empty_count` int(10) unsigned zerofill DEFAULT NULL COMMENT '상태(빈 객실수)',
  `guestroom_size` int(11) NOT NULL COMMENT '방크기',
  `guestroom_detail` varchar(50) DEFAULT NULL COMMENT '세부내용',
  `guestroom_register_date` date NOT NULL COMMENT '객실등록일자',
  `guestroom_update_date` date DEFAULT NULL COMMENT '마지막 객실 등록정보 수정일',
  PRIMARY KEY (`guestroom_no`),
  KEY `FK_guestroom_company` (`company_no`),
  KEY `FK_guestroom_accommodation` (`accommodation_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `FK_guestroom_accommodation` FOREIGN KEY (`accommodation_no`) REFERENCES `accommodation` (`accommodation_no`),
  CONSTRAINT `FK_guestroom_company` FOREIGN KEY (`company_no`) REFERENCES `company` (`company_no`),
  CONSTRAINT `FK_guestroom_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='객실';

-- 테이블 데이터 stayalive29.guestroom:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `guestroom` DISABLE KEYS */;
INSERT INTO `guestroom` (`guestroom_no`, `member_id`, `company_no`, `company_name`, `accommodation_no`, `accommodation_name`, `guestroom_name`, `guestroom_image_count`, `guestroom_buy_instant`, `guestroom_capacity`, `guestroom_capacity_max`, `guestroom_additional_perprice`, `guestroom_empty_count`, `guestroom_size`, `guestroom_detail`, `guestroom_register_date`, `guestroom_update_date`) VALUES
	(2, 'ID1', 9, '1', 6, '1', '1', 0000000001, 1, 1, 0, 0000000001, 0000000001, 1, '1', '2018-12-12', '2018-12-12');
/*!40000 ALTER TABLE `guestroom` ENABLE KEYS */;

-- 테이블 stayalive29.guestroom_option 구조 내보내기
CREATE TABLE IF NOT EXISTS `guestroom_option` (
  `guestroom_option_no` int(11) NOT NULL COMMENT '객실 옵션 등록 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '숙박 업체 회원 아이디',
  `company_no` int(11) NOT NULL COMMENT '업체 등록 번호(FK)',
  `company_name` varchar(50) NOT NULL COMMENT '업체명',
  `accommodation_no` int(11) NOT NULL COMMENT '숙소 등록 번호(FK)',
  `accommodation_name` varchar(50) NOT NULL COMMENT '숙소명',
  `guestroom_no` int(11) NOT NULL COMMENT '객실 등록 번호(FK)',
  `guestroom_name` varchar(50) NOT NULL COMMENT '객실명',
  `guestroom_option_name` varchar(50) DEFAULT NULL COMMENT '옵션명',
  `guestroom_additional_perday` int(10) unsigned zerofill DEFAULT NULL COMMENT '추가가격/1박',
  `guestroom_option_register_date` date NOT NULL COMMENT '옵션등록일자',
  `guestroom_option_update_date` date DEFAULT NULL COMMENT '마지막 옵션 등록정보 수정일',
  PRIMARY KEY (`guestroom_option_no`),
  KEY `FK_guestroom_option_company` (`company_no`),
  KEY `FK_guestroom_option_accommodation` (`accommodation_no`),
  KEY `FK_guestroom_option_guestroom` (`guestroom_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `FK_guestroom_option_accommodation` FOREIGN KEY (`accommodation_no`) REFERENCES `accommodation` (`accommodation_no`),
  CONSTRAINT `FK_guestroom_option_company` FOREIGN KEY (`company_no`) REFERENCES `company` (`company_no`),
  CONSTRAINT `FK_guestroom_option_guestroom` FOREIGN KEY (`guestroom_no`) REFERENCES `guestroom` (`guestroom_no`),
  CONSTRAINT `FK_guestroom_option_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='객실 옵션';

-- 테이블 데이터 stayalive29.guestroom_option:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `guestroom_option` DISABLE KEYS */;
INSERT INTO `guestroom_option` (`guestroom_option_no`, `member_id`, `company_no`, `company_name`, `accommodation_no`, `accommodation_name`, `guestroom_no`, `guestroom_name`, `guestroom_option_name`, `guestroom_additional_perday`, `guestroom_option_register_date`, `guestroom_option_update_date`) VALUES
	(0, 'ID1', 9, '1', 6, '1', 2, '1', '1', 0000010000, '2018-12-13', '2018-12-13');
/*!40000 ALTER TABLE `guestroom_option` ENABLE KEYS */;

-- 테이블 stayalive29.guestroom_service 구조 내보내기
CREATE TABLE IF NOT EXISTS `guestroom_service` (
  `guestroom_service_no` int(11) NOT NULL COMMENT '객실 서비스 등록 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '숙박 업체 회원 아이디',
  `company_no` int(11) NOT NULL COMMENT '업체 등록 번호(FK)',
  `company_name` varchar(50) NOT NULL COMMENT '업체명',
  `accommodation_no` int(11) NOT NULL COMMENT '숙소 등록 번호(FK)',
  `accommodation_name` varchar(50) NOT NULL COMMENT '숙소명',
  `guestroom_no` int(11) NOT NULL COMMENT '객실 등록 번호(FK)',
  `guestroom_name` varchar(50) NOT NULL COMMENT '객실명',
  `guestroom_service_category_no` int(11) NOT NULL COMMENT '객실 서비스 카테고리 번호(FK)',
  `guestroom_service_category_name` varchar(50) NOT NULL COMMENT '객실 서비스 카테고리 명',
  `guestroom_service_registration_date` date NOT NULL COMMENT '객실 서비스 등록 일자',
  `guestroom_service_update_date` date DEFAULT NULL COMMENT '마지막 객실 서비스 등록정보 수정일',
  PRIMARY KEY (`guestroom_service_no`),
  KEY `FK_guestroom_service_company` (`company_no`),
  KEY `FK_guestroom_service_accommodation` (`accommodation_no`),
  KEY `FK_guestroom_service_guestroom` (`guestroom_no`),
  KEY `FK_guestroom_service_guestroom_service_category` (`guestroom_service_category_no`),
  KEY `FK_guestroom_service_member` (`member_id`),
  CONSTRAINT `FK_guestroom_service_accommodation` FOREIGN KEY (`accommodation_no`) REFERENCES `accommodation` (`accommodation_no`),
  CONSTRAINT `FK_guestroom_service_company` FOREIGN KEY (`company_no`) REFERENCES `company` (`company_no`),
  CONSTRAINT `FK_guestroom_service_guestroom` FOREIGN KEY (`guestroom_no`) REFERENCES `guestroom` (`guestroom_no`),
  CONSTRAINT `FK_guestroom_service_guestroom_service_category` FOREIGN KEY (`guestroom_service_category_no`) REFERENCES `guestroom_service_category` (`guestroom_service_category_no`),
  CONSTRAINT `FK_guestroom_service_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='객실 서비스';

-- 테이블 데이터 stayalive29.guestroom_service:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `guestroom_service` DISABLE KEYS */;
/*!40000 ALTER TABLE `guestroom_service` ENABLE KEYS */;

-- 테이블 stayalive29.guestroom_service_category 구조 내보내기
CREATE TABLE IF NOT EXISTS `guestroom_service_category` (
  `guestroom_service_category_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '객실 서비스 카테고리 번호(PK)',
  `guestroom_service_category_name` varchar(50) NOT NULL COMMENT '객실 서비스 카테고리명',
  `guestroom_service_category_registration_date` date NOT NULL COMMENT '카테고리 등록일자',
  `guestroom_service_category_update_date` date DEFAULT NULL COMMENT '카테고리 수정일자',
  PRIMARY KEY (`guestroom_service_category_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='객실 서비스 카테고리';

-- 테이블 데이터 stayalive29.guestroom_service_category:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `guestroom_service_category` DISABLE KEYS */;
INSERT INTO `guestroom_service_category` (`guestroom_service_category_no`, `guestroom_service_category_name`, `guestroom_service_category_registration_date`, `guestroom_service_category_update_date`) VALUES
	(1, '와이파이\r\n', '2018-12-03', '0000-00-00'),
	(2, '주차가능\r\n', '2018-12-03', '0000-00-00'),
	(3, '객실내PC\r\n', '2018-12-03', '0000-00-00');
/*!40000 ALTER TABLE `guestroom_service_category` ENABLE KEYS */;

-- 테이블 stayalive29.image_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `image_file` (
  `image_file_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '이미지 파일 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원 아이디',
  `file_register_table_no` int(10) NOT NULL COMMENT '파일 등록 테이블 번호(FK)',
  `file_register_table_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '테이블명',
  `image_file_path` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '이미지 파일 경로',
  `image_file_real_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `image_file_stored_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '이미지 파일 이름',
  `image_file_ext` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '이미지 파일 확장자',
  `image_file_type` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '이미지 파일 형식',
  `image_file_size` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '이미지 파일 크기',
  `image_file_register_date` date NOT NULL COMMENT '이미지 파일 등록일',
  PRIMARY KEY (`image_file_no`),
  KEY `file_register_table_no` (`file_register_table_no`),
  KEY `FK_image_file_member` (`member_id`),
  CONSTRAINT `FK_image_file_file_register_table` FOREIGN KEY (`file_register_table_no`) REFERENCES `file_register_table` (`file_register_table_no`),
  CONSTRAINT `FK_image_file_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='이미지 파일';

-- 테이블 데이터 stayalive29.image_file:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `image_file` DISABLE KEYS */;
INSERT INTO `image_file` (`image_file_no`, `member_id`, `file_register_table_no`, `file_register_table_name`, `image_file_path`, `image_file_real_name`, `image_file_stored_name`, `image_file_ext`, `image_file_type`, `image_file_size`, `image_file_register_date`) VALUES
	(8, 'ID1', 6, '사업자등록', 'C:\\Users\\Administrator\\git\\stayalive\\src\\main\\webapp\\image\\business', '02map-7', '9bbb66fa-535e-4b3b-a327-3b3a59bfa713', 'gif', 'image/gif', '84', '2018-12-13'),
	(9, 'ID1', 3, '숙소', 'C:\\Users\\Administrator\\git\\stayalive\\src\\main\\webapp\\image\\business', '2612_tristan68', 'ce4a2258-91a1-424e-a9a6-2720dd426043', 'gif', 'image/gif', '184', '2018-12-14'),
	(10, 'ID1', 3, '숙소', 'C:\\Users\\Administrator\\git\\stayalive\\src\\main\\webapp\\image\\accommodation', '02map-7', '904e9f23-5060-4a97-9ab4-02a5fe71fa79', 'gif', 'image/gif', '84', '2018-12-14'),
	(11, 'ID1', 3, '숙소', 'C:\\Users\\Administrator\\git\\stayalive\\src\\main\\webapp\\image\\accommodation', '2612_tristan68', '751f0420-4e77-46ce-bcd6-6c5f4d8a2cf7', 'gif', 'image/gif', '184', '2018-12-14');
/*!40000 ALTER TABLE `image_file` ENABLE KEYS */;

-- 테이블 stayalive29.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `member_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '회원 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '아이디(UN)',
  `member_password` varchar(50) NOT NULL COMMENT '비밀번호',
  `member_name` varchar(50) NOT NULL COMMENT '이름',
  `member_nickname` varchar(50) NOT NULL COMMENT '닉네임',
  `member_birth` varchar(50) NOT NULL COMMENT '생년월일',
  `member_phone_number1` varchar(50) NOT NULL COMMENT '전화번호',
  `member_email` varchar(50) NOT NULL COMMENT '이메일',
  `member_email_accept` enum('Y','N') DEFAULT NULL COMMENT '이메일수신동의',
  `member_sms_accept` enum('Y','N') DEFAULT NULL COMMENT 'sms수신동의',
  `state_no` int(11) NOT NULL COMMENT '회원 상태 번호(FK)',
  `state_name` varchar(50) NOT NULL COMMENT '상태명',
  `group_no` int(11) NOT NULL COMMENT '회원 그룹 번호(FK)',
  `group_name` varchar(50) NOT NULL COMMENT '회원 그룹명',
  `rating_no` int(11) NOT NULL COMMENT '회원 등급 번호(FK)',
  `rating_name` varchar(50) NOT NULL COMMENT '회원 등급명',
  `member_option_no` int(11) DEFAULT NULL COMMENT '회원 옵션 번호(FK)',
  `member_option_name` varchar(50) DEFAULT NULL COMMENT '회원 옵션명',
  `member_sns_id` varchar(50) DEFAULT NULL COMMENT 'sns아이디',
  `member_register_date` datetime NOT NULL COMMENT '가입일자',
  `member_lastupdate_date` datetime NOT NULL COMMENT '마지막 정보수정일자',
  `member_lastlogout_date` datetime NOT NULL COMMENT '마지막 로그아웃일자',
  `member_lastlogin_date` datetime NOT NULL COMMENT '마지막 로그인일자',
  `member_login_count` int(11) NOT NULL COMMENT '로그인 횟수',
  PRIMARY KEY (`member_no`),
  UNIQUE KEY `member_id` (`member_id`),
  UNIQUE KEY `member_sns_id` (`member_sns_id`),
  KEY `FK_member_member_state` (`state_no`),
  KEY `FK_member_member_group` (`group_no`),
  KEY `FK_member_member_rating` (`rating_no`),
  KEY `FK_member_member_option` (`member_option_no`),
  CONSTRAINT `FK_member_member_group` FOREIGN KEY (`group_no`) REFERENCES `member_group` (`group_no`),
  CONSTRAINT `FK_member_member_option` FOREIGN KEY (`member_option_no`) REFERENCES `member_option` (`member_option_no`),
  CONSTRAINT `FK_member_member_rating` FOREIGN KEY (`rating_no`) REFERENCES `member_rating` (`rating_no`),
  CONSTRAINT `FK_member_member_state` FOREIGN KEY (`state_no`) REFERENCES `member_state` (`state_no`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8 COMMENT='회원정보';

-- 테이블 데이터 stayalive29.member:~20 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` (`member_no`, `member_id`, `member_password`, `member_name`, `member_nickname`, `member_birth`, `member_phone_number1`, `member_email`, `member_email_accept`, `member_sms_accept`, `state_no`, `state_name`, `group_no`, `group_name`, `rating_no`, `rating_name`, `member_option_no`, `member_option_name`, `member_sns_id`, `member_register_date`, `member_lastupdate_date`, `member_lastlogout_date`, `member_lastlogin_date`, `member_login_count`) VALUES
	(1, 'ID1', 'PW2', '회원', '닉네임', '2018-12-11', '0', '', 'Y', 'Y', 1, '', 2, '', 1, '', 1, '', NULL, '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00', 0),
	(25, 'id011', '123', '박형민', '1234', '2018-12-07', '105123', 'asdfasdf', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 2, '프리미엄2', NULL, '2018-12-12 15:30:37', '2018-12-12 15:30:37', '2018-12-12 15:30:37', '2018-12-12 15:30:37', 1),
	(109, 'id001', '1234', '박형민', '1234456', '2018-12-05', '0105123', 'asdf@hana.com', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 14:54:08', '2018-12-18 14:54:08', '2018-12-18 14:54:08', '2018-12-18 14:54:08', 1),
	(110, 'id0028', '7890', '박형민', '1235688', '2018-12-05', '0105123', 'asdf@hana.com', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 15:02:26', '2018-12-18 15:02:26', '2018-12-18 15:02:26', '2018-12-18 15:02:26', 1),
	(111, 'id002', '1234', 'ASDF', '123787', '2018-12-04', '0105123', 'asdf@hana.com', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 15:15:10', '2018-12-18 15:15:10', '2018-12-18 15:15:10', '2018-12-18 15:15:10', 1),
	(112, 'id003', '1234', 'ASDF', '75675', '2018-12-27', '010512df', 'asdfasdf@adfa', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 15:18:45', '2018-12-18 15:18:45', '2018-12-18 15:18:45', '2018-12-18 15:18:45', 1),
	(113, 'id004', '1234', 'ASDF', '123551', '2018-12-03', '010512', 'asdfasdf@adfa', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 15:22:51', '2018-12-18 15:22:51', '2018-12-18 15:22:51', '2018-12-18 15:22:51', 1),
	(114, 'id006', '1234', 'ASDF', '1441251', '2018-12-03', '010512', 'asdfasdf@adfa', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 15:34:15', '2018-12-18 15:34:15', '2018-12-18 15:34:15', '2018-12-18 15:34:15', 1),
	(115, '12345', '1234', '박형민', '박형민', '2018-12-06', '0105123', 'asdf@hana.com', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 15:52:42', '2018-12-18 15:52:42', '2018-12-18 15:52:42', '2018-12-18 15:52:42', 1),
	(116, 'id0056', '1234', 'ASDF', '1234', '2018-12-06', '010512', 'asdf@hana.com', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 15:56:48', '2018-12-18 15:56:48', '2018-12-18 15:56:48', '2018-12-18 15:56:48', 1),
	(118, 'id01231', '1234', '1231', '51513', '2018-12-10', '0105123', 'asdf@hana.com', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 16:24:36', '2018-12-18 16:24:36', '2018-12-18 16:24:36', '2018-12-18 16:24:36', 1),
	(119, 'id00566', '1234', 'ASDF', '1415', '2018-12-12', '010512', 'asdfasdf@adfa', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 16:28:05', '2018-12-18 16:28:05', '2018-12-18 16:28:05', '2018-12-18 16:28:05', 1),
	(121, 'id0145', '1234', '박형민', 'vksdlk', '2018-12-05', '0105123', 'asdf@hana.com', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 16:32:55', '2018-12-18 16:32:55', '2018-12-18 16:32:55', '2018-12-18 16:32:55', 1),
	(123, 'id0ad', '1234', '박형민', 'vffbfd', '2018-12-05', '0105123', 'asdf@hana.com', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 16:33:45', '2018-12-18 16:33:45', '2018-12-18 16:33:45', '2018-12-18 16:33:45', 1),
	(124, '', '', '', '', '', '', '', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 17:08:08', '2018-12-18 17:08:08', '2018-12-18 17:08:08', '2018-12-18 17:08:08', 1),
	(126, '123', '', '', '', '', '', '', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-18 17:08:43', '2018-12-18 17:08:43', '2018-12-18 17:08:43', '2018-12-18 17:08:43', 1),
	(128, '45647', '1234', '박형민', '1235', '2018-12-05', '0105123', 'asd0f@hana', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-19 10:15:54', '2018-12-19 10:15:54', '2018-12-19 10:15:54', '2018-12-19 10:15:54', 1),
	(129, 'asdff', '1234', '박형민', '1234d', '2018-12-05', '0105123', 'asdf@hana.com', 'Y', 'Y', 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-19 11:24:18', '2018-12-19 11:24:18', '2018-12-19 11:24:18', '2018-12-19 11:24:18', 1),
	(130, 'id002jyj', '1234', '박형민', '1234456j', '2018-12-06', '0105123', 'asd0f@hana.com', 'Y', NULL, 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-19 16:27:27', '2018-12-19 16:27:27', '2018-12-19 16:27:27', '2018-12-19 16:27:27', 1),
	(131, 'id003d', '1234', '박형민', 'asdfas', '19890829', '010512', 'asdf@hana.com', NULL, NULL, 1, '123', 1, '123', 1, '123', 1, '123', NULL, '2018-12-19 16:31:59', '2018-12-19 16:31:59', '2018-12-19 16:31:59', '2018-12-19 16:31:59', 1);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;

-- 테이블 stayalive29.member_group 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_group` (
  `group_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 그룹 번호(PK)',
  `group_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '그룹명',
  `group_register_date` date NOT NULL COMMENT '회원 그룹 등록일자',
  PRIMARY KEY (`group_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='회원 그룹';

-- 테이블 데이터 stayalive29.member_group:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_group` DISABLE KEYS */;
INSERT INTO `member_group` (`group_no`, `group_name`, `group_register_date`) VALUES
	(1, '게스트', '2018-12-03'),
	(2, '호스트', '2018-12-03'),
	(3, '관리자', '2018-12-03');
/*!40000 ALTER TABLE `member_group` ENABLE KEYS */;

-- 테이블 stayalive29.member_group_update 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_group_update` (
  `update_group_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 그룹 변경 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원아이디',
  `group_no` int(10) NOT NULL COMMENT '변경된 회원 그룹 번호(FK)',
  `update_group_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '변경된 그룹명',
  `update_group_date` date DEFAULT NULL COMMENT '회원 그룹 변경일',
  PRIMARY KEY (`update_group_no`),
  KEY `FK_member_group_update_member_group` (`group_no`),
  KEY `FK_member_group_update_member` (`member_id`),
  CONSTRAINT `FK_member_group_update_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK_member_group_update_member_group` FOREIGN KEY (`group_no`) REFERENCES `member_group` (`group_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='회원 그룹 변경';

-- 테이블 데이터 stayalive29.member_group_update:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_group_update` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_group_update` ENABLE KEYS */;

-- 테이블 stayalive29.member_nickname_update 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_nickname_update` (
  `update_nickname_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 닉네임 변경내역 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원아이디',
  `update_nickname` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '변경한 닉네임',
  `update_nickname_date` date NOT NULL COMMENT '닉네임 변경일자',
  PRIMARY KEY (`update_nickname_no`),
  KEY `FK_member_nickname_update_member` (`member_id`),
  CONSTRAINT `FK_member_nickname_update_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='회원 닉네임 변경';

-- 테이블 데이터 stayalive29.member_nickname_update:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_nickname_update` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_nickname_update` ENABLE KEYS */;

-- 테이블 stayalive29.member_option 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_option` (
  `member_option_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 옵션 번호(PK)',
  `member_option_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '옵션명',
  `member_option_detail` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '옵션 내용',
  `member_option_date` date NOT NULL COMMENT '회원 옵션 등록일',
  PRIMARY KEY (`member_option_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='회원 옵션';

-- 테이블 데이터 stayalive29.member_option:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_option` DISABLE KEYS */;
INSERT INTO `member_option` (`member_option_no`, `member_option_name`, `member_option_detail`, `member_option_date`) VALUES
	(1, '프리미엄01', 'option01', '2018-12-03'),
	(2, '프리미엄02', 'option02', '2018-12-03');
/*!40000 ALTER TABLE `member_option` ENABLE KEYS */;

-- 테이블 stayalive29.member_option_update 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_option_update` (
  `update_member_option_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 옵션 변경 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원아이디',
  `member_option_no` int(10) NOT NULL COMMENT '변경된 회원 옵션 번호(FK)',
  `update_member_option_date` date NOT NULL COMMENT '옵션 변경일자',
  PRIMARY KEY (`update_member_option_no`),
  KEY `FK_member_option_update_member_option` (`member_option_no`),
  KEY `FK_member_option_update_member` (`member_id`),
  CONSTRAINT `FK_member_option_update_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK_member_option_update_member_option` FOREIGN KEY (`member_option_no`) REFERENCES `member_option` (`member_option_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='회원 옵션 변경';

-- 테이블 데이터 stayalive29.member_option_update:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_option_update` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_option_update` ENABLE KEYS */;

-- 테이블 stayalive29.member_rating 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_rating` (
  `rating_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 등급 번호(PK)',
  `rating_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '등급명',
  `rating_register_date` date NOT NULL COMMENT '회원 등급 등록일',
  `buyer_year_volume` int(10) unsigned zerofill DEFAULT NULL COMMENT '구매자 1년간 거래량(이상)',
  `seller_year_volume` int(10) unsigned zerofill DEFAULT NULL COMMENT '판매자 1년간 거래량(이상)',
  PRIMARY KEY (`rating_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='회원 등급';

-- 테이블 데이터 stayalive29.member_rating:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_rating` DISABLE KEYS */;
INSERT INTO `member_rating` (`rating_no`, `rating_name`, `rating_register_date`, `buyer_year_volume`, `seller_year_volume`) VALUES
	(1, '실버', '2018-12-03', 0000000010, 0000000100),
	(2, '골드', '2018-12-03', 0000000030, 0000000300),
	(3, 'vip', '2018-12-03', 0000000050, 0000000500),
	(4, 'vvip', '2018-12-03', 0000000100, 0000001000);
/*!40000 ALTER TABLE `member_rating` ENABLE KEYS */;

-- 테이블 stayalive29.member_rating_update 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_rating_update` (
  `update_rating_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 등급 변경 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원아이디',
  `rating_no` int(10) NOT NULL COMMENT '변경된 회원 등급 번호(FK)',
  `rating_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '변경된 등급명',
  `rating_update_date` date NOT NULL COMMENT '회원 등급 변경일자',
  PRIMARY KEY (`update_rating_no`),
  KEY `FK_member_rating_update_member_rating` (`rating_no`),
  KEY `FK_member_rating_update_member` (`member_id`),
  CONSTRAINT `FK_member_rating_update_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK_member_rating_update_member_rating` FOREIGN KEY (`rating_no`) REFERENCES `member_rating` (`rating_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT=' 회원 등급 변경';

-- 테이블 데이터 stayalive29.member_rating_update:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_rating_update` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_rating_update` ENABLE KEYS */;

-- 테이블 stayalive29.member_sms 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_sms` (
  `member_sms_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 sms 인증 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원 아이디',
  `auth_confirmcode` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '확인코드',
  `comfirmcode_send_date` date NOT NULL COMMENT '확인코드 발송시간',
  `comfirmcode_auth_date` date NOT NULL COMMENT '확인코드 인증시간',
  `comfirmcode_resend_check` enum('Y','N') COLLATE utf8_bin DEFAULT NULL COMMENT '확인코드 재발송여부',
  PRIMARY KEY (`member_sms_no`),
  KEY `FK_member_sms_member` (`member_id`),
  CONSTRAINT `FK_member_sms_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='회원 sms  인증';

-- 테이블 데이터 stayalive29.member_sms:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_sms` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_sms` ENABLE KEYS */;

-- 테이블 stayalive29.member_state 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_state` (
  `state_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 상태 번호(PK)',
  `state_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '상태명',
  `state_register_date` date NOT NULL COMMENT '회원 상태 등록일자',
  PRIMARY KEY (`state_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='회원 상태';

-- 테이블 데이터 stayalive29.member_state:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_state` DISABLE KEYS */;
INSERT INTO `member_state` (`state_no`, `state_name`, `state_register_date`) VALUES
	(1, '일반', '2018-12-03'),
	(2, '탈퇴신청', '0000-00-00'),
	(3, '탈퇴처리', '0000-00-00');
/*!40000 ALTER TABLE `member_state` ENABLE KEYS */;

-- 테이블 stayalive29.member_trading_volume 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_trading_volume` (
  `trading_volume_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 거래량 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원아이디',
  `trading_type` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '회원 거래방식(판매,구매)',
  `trading_volume_month` int(10) unsigned zerofill DEFAULT NULL COMMENT '월별 거래량',
  `trading_update_date` date DEFAULT NULL COMMENT '거래량 변경 일자',
  `trading_year` int(4) DEFAULT NULL COMMENT '연도',
  `trading_month` int(2) DEFAULT NULL COMMENT '월',
  PRIMARY KEY (`trading_volume_no`),
  KEY `FK_member_trading_volume_member` (`member_id`),
  CONSTRAINT `FK_member_trading_volume_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='회원 거래량';

-- 테이블 데이터 stayalive29.member_trading_volume:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_trading_volume` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_trading_volume` ENABLE KEYS */;

-- 테이블 stayalive29.member_withdraw 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_withdraw` (
  `withdraw_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원 탈퇴 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원 아이디',
  `withdraw_ip` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '회원 IP',
  `withdraw_date` date NOT NULL COMMENT '회원 탈퇴 일자',
  PRIMARY KEY (`withdraw_no`),
  KEY `FK_member_withdraw_member` (`member_id`),
  CONSTRAINT `FK_member_withdraw_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='회원 탈퇴';

-- 테이블 데이터 stayalive29.member_withdraw:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `member_withdraw` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_withdraw` ENABLE KEYS */;

-- 테이블 stayalive29.payment 구조 내보내기
CREATE TABLE IF NOT EXISTS `payment` (
  `payment_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '결제 번호(PK)',
  `payment_category_no` int(11) NOT NULL COMMENT '결제 카테고리 번호(FK)',
  `payment_category_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '카테고리명',
  `payment_info` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '결제 정보',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '회원 아이디',
  `payment_price` int(10) NOT NULL COMMENT '결제 가격',
  `payment_state_category_no` int(10) NOT NULL COMMENT '결제 상태 카테고리 번호(FK)',
  `payment_state_category_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '상태 카테고리명',
  `payment_date` date NOT NULL COMMENT '결제 정보 등록일',
  PRIMARY KEY (`payment_no`),
  KEY `FK_payment_payment_category` (`payment_category_no`),
  KEY `FK_payment_payment_state_category` (`payment_state_category_no`),
  KEY `FK_payment_member` (`member_id`),
  CONSTRAINT `FK_payment_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK_payment_payment_category` FOREIGN KEY (`payment_category_no`) REFERENCES `payment_category` (`payment_category_no`),
  CONSTRAINT `FK_payment_payment_state_category` FOREIGN KEY (`payment_state_category_no`) REFERENCES `payment_state_category` (`payment_state_category_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='결제';

-- 테이블 데이터 stayalive29.payment:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- 테이블 stayalive29.payment_category 구조 내보내기
CREATE TABLE IF NOT EXISTS `payment_category` (
  `payment_category_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '결제 카테고리 번호(PK)',
  `payment_category_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '카테고리명',
  `payment_category_date` date NOT NULL COMMENT '카테고리 등록일자',
  PRIMARY KEY (`payment_category_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='결제 카테고리';

-- 테이블 데이터 stayalive29.payment_category:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `payment_category` DISABLE KEYS */;
INSERT INTO `payment_category` (`payment_category_no`, `payment_category_name`, `payment_category_date`) VALUES
	(1, '역경매', '2018-12-03'),
	(2, '네덜란드식 경매', '2018-12-03'),
	(3, '광고', '2018-12-03'),
	(4, '프리미엄', '2018-12-03');
/*!40000 ALTER TABLE `payment_category` ENABLE KEYS */;

-- 테이블 stayalive29.payment_state_category 구조 내보내기
CREATE TABLE IF NOT EXISTS `payment_state_category` (
  `payment_state_category_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '결제 상태 카테고리 번호(PK)',
  `payment_state_category_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '상태 카테고리명',
  `payment_state_category_date` date NOT NULL COMMENT '상태 카테고리 등록일자',
  PRIMARY KEY (`payment_state_category_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='결제 상태';

-- 테이블 데이터 stayalive29.payment_state_category:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `payment_state_category` DISABLE KEYS */;
INSERT INTO `payment_state_category` (`payment_state_category_no`, `payment_state_category_name`, `payment_state_category_date`) VALUES
	(1, '결제대기', '2018-12-03'),
	(2, '결제완료', '2018-12-03'),
	(3, '이용완료', '2018-12-03');
/*!40000 ALTER TABLE `payment_state_category` ENABLE KEYS */;

-- 테이블 stayalive29.reverseauction_register 구조 내보내기
CREATE TABLE IF NOT EXISTS `reverseauction_register` (
  `reverseauction_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '역경매 등록 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '구매회원아이디',
  `reverseauction_register_date` date DEFAULT NULL COMMENT '등록일',
  `reverseauction_update_date` date DEFAULT NULL COMMENT '수정일',
  `reverseauction_tender_limit` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '입찰 한도가',
  `reverseauction_tenderclose_date` date DEFAULT NULL COMMENT '입찰 마감 일자',
  `reverseauction_rooming_date` date DEFAULT NULL COMMENT '숙소 입실일자',
  `reverseauction_leaving_date` date DEFAULT NULL COMMENT '숙소 퇴실일자',
  `reverseauction_title` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '제목',
  `reverseauction_address` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '숙소 주소',
  `reverseauction_address_more` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '추가 주소 정보',
  `reverseauction_hits` int(10) DEFAULT NULL COMMENT '조회수',
  `reverseauction_content` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '내용',
  `reverseauction_tender_count` int(10) DEFAULT NULL COMMENT '입찰건수',
  `auction_state_category_no` int(10) NOT NULL COMMENT '경매 상태 카테고리 번호(FK)',
  `auction_state_category_name` varchar(5) COLLATE utf8_bin DEFAULT NULL COMMENT '상태 카테고리명',
  `reverseauction_number_of_people` int(10) DEFAULT NULL COMMENT '인원수',
  PRIMARY KEY (`reverseauction_no`),
  KEY `auction_state_category_no` (`auction_state_category_no`),
  KEY `FK_reverseauction_register_member` (`member_id`),
  CONSTRAINT `FK_reverseauction_register_auction_state_category` FOREIGN KEY (`auction_state_category_no`) REFERENCES `auction_state_category` (`auction_state_category_no`),
  CONSTRAINT `FK_reverseauction_register_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='역경매등록';

-- 테이블 데이터 stayalive29.reverseauction_register:~10 rows (대략적) 내보내기
/*!40000 ALTER TABLE `reverseauction_register` DISABLE KEYS */;
INSERT INTO `reverseauction_register` (`reverseauction_no`, `member_id`, `reverseauction_register_date`, `reverseauction_update_date`, `reverseauction_tender_limit`, `reverseauction_tenderclose_date`, `reverseauction_rooming_date`, `reverseauction_leaving_date`, `reverseauction_title`, `reverseauction_address`, `reverseauction_address_more`, `reverseauction_hits`, `reverseauction_content`, `reverseauction_tender_count`, `auction_state_category_no`, `auction_state_category_name`, `reverseauction_number_of_people`) VALUES
	(13, 'ID1', '2018-12-12', NULL, '300000', '2018-12-04', '2018-12-11', '2018-12-14', '제목', '주소1', '상세주소1', 0, '내용1', 0, 1, '낙찰 대기', 6),
	(16, 'ID1', '2018-12-14', NULL, '789456', '2018-12-10', '2018-12-07', '2018-12-12', '제목2', '주소4', '상세주소4', 0, '조건 내 적당한 호텔 구함', 0, 1, '낙찰 대기', 5),
	(17, 'ID1', '2018-12-17', NULL, '50000', '2018-12-12', '2018-12-14', '2018-12-15', '제목', '주소4', '상세주소4', 0, '내용2', 0, 1, '낙찰 대기', 2),
	(18, 'ID1', '2018-12-17', NULL, '50000', '2018-12-12', '2018-12-14', '2018-12-15', '제목', '주소4', '상세주소4', 0, '내용2', 0, 1, '낙찰 대기', 2),
	(19, 'ID1', '2018-12-17', NULL, '50000', '2018-12-12', '2018-12-14', '2018-12-15', '제목', '주소4', '상세주소4', 0, '내용2', 0, 1, '낙찰 대기', 2),
	(20, 'ID1', '2018-12-17', NULL, '50000', '2018-12-12', '2018-12-14', '2018-12-15', '제목', '주소4', '상세주소4', 0, '내용2', 0, 1, '낙찰 대기', 2),
	(21, 'ID1', '2018-12-17', NULL, '50000', '2018-12-12', '2018-12-14', '2018-12-15', '제목', '주소4', '상세주소4', 0, '내용2', 0, 1, '낙찰 대기', 2),
	(22, 'ID1', '2018-12-17', NULL, '50000', '2018-12-12', '2018-12-14', '2018-12-15', '제목', '주소4', '상세주소4', 0, '내용2', 0, 1, '낙찰 대기', 2),
	(23, 'ID1', '2018-12-17', NULL, '50000', '2018-12-12', '2018-12-14', '2018-12-15', '제목', '주소4', '상세주소4', 0, '내용2', 0, 1, '낙찰 대기', 2),
	(24, 'ID1', '2018-12-17', NULL, '50000', '2018-12-12', '2018-12-14', '2018-12-15', '제목', '주소4', '상세주소4', 0, '내용2', 1, 1, '낙찰 대기', 2);
/*!40000 ALTER TABLE `reverseauction_register` ENABLE KEYS */;

-- 테이블 stayalive29.reverseauction_successfulbid 구조 내보내기
CREATE TABLE IF NOT EXISTS `reverseauction_successfulbid` (
  `reverseauction_successfulbid_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '역경매 낙찰 번호(PK)',
  `reverseauction_no` int(10) NOT NULL COMMENT '역경매 등록 번호(FK)',
  `reverseauction_tender_no` int(10) NOT NULL COMMENT '역경매 입찰 번호(FK)',
  `guestroom_option_no` int(10) NOT NULL COMMENT '객실 옵션 등록 번호(FK)',
  `guestroom_option_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '옵션명',
  `guestroom_additional_price` int(10) DEFAULT NULL COMMENT '추가 가격/1박',
  `reverseauction_successfulbid_price` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '최종 낙찰가',
  `reverseauction_successfulbid_date` date DEFAULT NULL COMMENT '낙찰일',
  `reverseauction_rooming_date` date DEFAULT NULL COMMENT '숙소 입실일',
  `reverseauction_leaving_date` date DEFAULT NULL COMMENT '숙소 퇴실일',
  `auction_state_category_no` int(10) NOT NULL COMMENT '경매 상태 카테고리 번호(FK)',
  `auction_state_category_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '상태 카테고리명',
  PRIMARY KEY (`reverseauction_successfulbid_no`),
  KEY `FK_reverseauction_successfulbid_reverseauction_register` (`reverseauction_no`),
  KEY `FK_reverseauction_successfulbid_payment_state_category` (`auction_state_category_no`),
  KEY `FK_reverseauction_successfulbid_reverseauction_tender` (`reverseauction_tender_no`),
  KEY `FK_reverseauction_successfulbid_guestroom_option` (`guestroom_option_no`),
  CONSTRAINT `FK_reverseauction_successfulbid_guestroom_option` FOREIGN KEY (`guestroom_option_no`) REFERENCES `guestroom_option` (`guestroom_option_no`),
  CONSTRAINT `FK_reverseauction_successfulbid_payment_state_category` FOREIGN KEY (`auction_state_category_no`) REFERENCES `payment_state_category` (`payment_state_category_no`),
  CONSTRAINT `FK_reverseauction_successfulbid_reverseauction_register` FOREIGN KEY (`reverseauction_no`) REFERENCES `reverseauction_register` (`reverseauction_no`),
  CONSTRAINT `FK_reverseauction_successfulbid_reverseauction_tender` FOREIGN KEY (`reverseauction_tender_no`) REFERENCES `reverseauction_tender` (`reverseauction_tender_no`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='역경매 낙찰';

-- 테이블 데이터 stayalive29.reverseauction_successfulbid:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `reverseauction_successfulbid` DISABLE KEYS */;
INSERT INTO `reverseauction_successfulbid` (`reverseauction_successfulbid_no`, `reverseauction_no`, `reverseauction_tender_no`, `guestroom_option_no`, `guestroom_option_name`, `guestroom_additional_price`, `reverseauction_successfulbid_price`, `reverseauction_successfulbid_date`, `reverseauction_rooming_date`, `reverseauction_leaving_date`, `auction_state_category_no`, `auction_state_category_name`) VALUES
	(15, 16, 53, 0, '1', 0, '1', '2018-12-17', '2018-12-07', '2018-12-12', 2, '낙찰완료'),
	(20, 13, 52, 0, '1', 0, '1', '2018-12-18', '2018-12-11', '2018-12-14', 2, '낙찰완료');
/*!40000 ALTER TABLE `reverseauction_successfulbid` ENABLE KEYS */;

-- 테이블 stayalive29.reverseauction_tender 구조 내보내기
CREATE TABLE IF NOT EXISTS `reverseauction_tender` (
  `reverseauction_tender_no` int(10) NOT NULL AUTO_INCREMENT COMMENT '역경매 입찰 번호(PK)',
  `member_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '숙박업체회원아이디',
  `company_no` int(10) NOT NULL COMMENT '업체 등록 번호(FK)',
  `company_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '업체명',
  `accommodation_no` int(10) NOT NULL COMMENT '숙소 등록 번호(FK)',
  `accommodation_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '숙소명',
  `guestroom_no` int(10) NOT NULL COMMENT '객실 등록 번호(FK)',
  `guestroom_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '객실명',
  `reverseauction_no` int(10) NOT NULL COMMENT '역경매 등록 번호(FK)',
  `accommodation_guestroom_allcount` int(10) DEFAULT NULL COMMENT '총 객실 수',
  `guestroom_state_count` int(10) DEFAULT NULL COMMENT '상태(빈 객실수)',
  `reverseauction_tender_date` date DEFAULT NULL COMMENT '입찰일',
  `reverseauction_tender_update_date` date DEFAULT NULL COMMENT '입찰 수정일',
  `reverseauction_tender_content` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '기타 적고싶은 말',
  `reverseauction_tender_price` int(10) DEFAULT NULL COMMENT '가격',
  `auction_state_category_no` int(11) NOT NULL COMMENT '경매 상태 카테고리 번호(FK)',
  `auction_state_category_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '상태 카테고리명',
  PRIMARY KEY (`reverseauction_tender_no`),
  KEY `FK_reverseauction_tender_auction_state_category` (`auction_state_category_no`),
  KEY `FK_company_no` (`company_no`),
  KEY `accommodation_no` (`accommodation_no`),
  KEY `guestroom_no` (`guestroom_no`),
  KEY `reverseauction_no` (`reverseauction_no`),
  KEY `FK_reverseauction_tender_member` (`member_id`),
  CONSTRAINT `FK_company_no` FOREIGN KEY (`company_no`) REFERENCES `company` (`company_no`),
  CONSTRAINT `FK_reverseauction_tender_accommodation` FOREIGN KEY (`accommodation_no`) REFERENCES `accommodation` (`accommodation_no`),
  CONSTRAINT `FK_reverseauction_tender_auction_state_category` FOREIGN KEY (`auction_state_category_no`) REFERENCES `auction_state_category` (`auction_state_category_no`),
  CONSTRAINT `FK_reverseauction_tender_guestroom` FOREIGN KEY (`guestroom_no`) REFERENCES `guestroom` (`guestroom_no`),
  CONSTRAINT `FK_reverseauction_tender_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK_reverseauction_tender_reverseauction_register` FOREIGN KEY (`reverseauction_no`) REFERENCES `reverseauction_register` (`reverseauction_no`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='역경매 입찰';

-- 테이블 데이터 stayalive29.reverseauction_tender:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `reverseauction_tender` DISABLE KEYS */;
INSERT INTO `reverseauction_tender` (`reverseauction_tender_no`, `member_id`, `company_no`, `company_name`, `accommodation_no`, `accommodation_name`, `guestroom_no`, `guestroom_name`, `reverseauction_no`, `accommodation_guestroom_allcount`, `guestroom_state_count`, `reverseauction_tender_date`, `reverseauction_tender_update_date`, `reverseauction_tender_content`, `reverseauction_tender_price`, `auction_state_category_no`, `auction_state_category_name`) VALUES
	(52, 'ID1', 9, '1', 6, '1', 2, '1', 13, 1, 1, '2018-12-13', NULL, '1', 1, 1, '낙찰대기중'),
	(53, 'ID1', 242, '1', 8, '1', 2, '1', 16, 1, 1, '2018-12-14', '2018-12-14', '1', 1, 1, '낙찰대기중'),
	(54, 'ID1', 9, '1', 6, '1', 2, '1', 24, 1, 1, '2018-12-19', NULL, '1', 1, 1, '낙찰대기중'),
	(55, 'ID1', 9, '1', 6, '1', 2, '1', 24, 1, 1, '2018-12-19', NULL, '1', 1, 1, '낙찰대기중');
/*!40000 ALTER TABLE `reverseauction_tender` ENABLE KEYS */;

-- 테이블 stayalive29.review 구조 내보내기
CREATE TABLE IF NOT EXISTS `review` (
  `review_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '리뷰 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '구매회원아이디',
  `accommodation_no` int(11) NOT NULL COMMENT '숙소 등록 번호(FK)',
  `accommodation_name` varchar(50) DEFAULT NULL COMMENT '숙소명',
  `review_title` varchar(50) DEFAULT NULL COMMENT '제목',
  `review_content` varchar(50) DEFAULT NULL COMMENT '내용',
  `review_score` int(11) DEFAULT NULL COMMENT '평점',
  `review_recommand` int(11) DEFAULT NULL COMMENT '리뷰추천',
  `review_date` date DEFAULT NULL COMMENT '작성일',
  PRIMARY KEY (`review_no`),
  KEY `FK_review_accommodation` (`accommodation_no`),
  KEY `FK_review_member` (`member_id`),
  CONSTRAINT `FK_review_accommodation` FOREIGN KEY (`accommodation_no`) REFERENCES `accommodation` (`accommodation_no`),
  CONSTRAINT `FK_review_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='리뷰관리(구매자)';

-- 테이블 데이터 stayalive29.review:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;

-- 테이블 stayalive29.wishlist_accommodation 구조 내보내기
CREATE TABLE IF NOT EXISTS `wishlist_accommodation` (
  `wishlist_accommodation_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '찜하기 숙소 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '회원 아이디',
  `accommodation_no` int(11) NOT NULL COMMENT '숙소 등록 번호(FK)',
  `accommodation_name` varchar(50) DEFAULT NULL COMMENT '숙소명',
  `wishlist_date` date DEFAULT NULL COMMENT '찜한 날짜',
  PRIMARY KEY (`wishlist_accommodation_no`),
  KEY `FK_wishlist_accommodation_accommodation` (`accommodation_no`),
  KEY `FK_wishlist_accommodation_member` (`member_id`),
  CONSTRAINT `FK_wishlist_accommodation_accommodation` FOREIGN KEY (`accommodation_no`) REFERENCES `accommodation` (`accommodation_no`),
  CONSTRAINT `FK_wishlist_accommodation_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='찜하기 숙박';

-- 테이블 데이터 stayalive29.wishlist_accommodation:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `wishlist_accommodation` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist_accommodation` ENABLE KEYS */;

-- 테이블 stayalive29.wishlist_dutchauction 구조 내보내기
CREATE TABLE IF NOT EXISTS `wishlist_dutchauction` (
  `wishlist_dutchauction_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '찜하기 네덜란드식 경매 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '회원 아이디',
  `dutchauction_no` int(11) NOT NULL COMMENT '네덜란드식 경매 번호(FK)',
  `wishlist_date` date NOT NULL COMMENT '찜한 날짜',
  PRIMARY KEY (`wishlist_dutchauction_no`),
  KEY `FK_wishlist_dutchauction_dutchauction_register` (`dutchauction_no`),
  KEY `FK_wishlist_dutchauction_member` (`member_id`),
  CONSTRAINT `FK_wishlist_dutchauction_dutchauction_register` FOREIGN KEY (`dutchauction_no`) REFERENCES `dutchauction_register` (`dutchauction_no`),
  CONSTRAINT `FK_wishlist_dutchauction_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='네덜란드식 경매 찜하기(구매자)';

-- 테이블 데이터 stayalive29.wishlist_dutchauction:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `wishlist_dutchauction` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist_dutchauction` ENABLE KEYS */;

-- 테이블 stayalive29.wishlist_reverseauction 구조 내보내기
CREATE TABLE IF NOT EXISTS `wishlist_reverseauction` (
  `wishlist_reverseauction_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '찜하기 역경매 번호(PK)',
  `member_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '회원 아이디',
  `reverseauction_no` int(11) NOT NULL COMMENT '역경매 번호(FK)',
  `wishlist_date` date NOT NULL COMMENT '찜한 날짜',
  PRIMARY KEY (`wishlist_reverseauction_no`),
  KEY `FK_wishlist_reverseauction_reverseauction_register` (`reverseauction_no`),
  KEY `FK_wishlist_reverseauction_member` (`member_id`),
  CONSTRAINT `FK_wishlist_reverseauction_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FK_wishlist_reverseauction_reverseauction_register` FOREIGN KEY (`reverseauction_no`) REFERENCES `reverseauction_register` (`reverseauction_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='역경매등록정보찜하기(판매자)';

-- 테이블 데이터 stayalive29.wishlist_reverseauction:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `wishlist_reverseauction` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist_reverseauction` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
