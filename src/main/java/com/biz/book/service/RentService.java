package com.biz.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.book.mapper.RentMapper;
import com.biz.book.model.BookVO;
import com.biz.book.model.RentVO;

@Service
public class RentService {

	@Autowired
	RentMapper rentMapper;
	
	@Autowired
	BookService bookService;

	public List<RentVO> selectAllRents() {

		return rentMapper.selectAllRents();
	}

	public List<RentVO> findByRentName(String searchDate) {

		return rentMapper.findByRentDate(searchDate);
	}

	public RentVO findByRentID(long rent_seq) {

		return rentMapper.findByRentID(rent_seq);
	}

	public int insertRent(RentVO rentVO) {

		return rentMapper.insertRent(rentVO);
	}

	public int updateRent(RentVO rentVO) {

		return rentMapper.updateRent(rentVO);
	}

	public int deleteRent(long rent_seq) {

		return rentMapper.deleteRent(rent_seq);
	}

	public RentVO findByRentISBN(String book_isbn) {
		
		BookVO bookVO=bookService.findByBookISBN(book_isbn);
		
		return rentMapper.findByRentBookSeq(bookVO.getBook_seq());
	}
	
	public List<RentVO> findByRentDate(String searchDate){
		
		return rentMapper.findByRentDate(searchDate);
	}
}










