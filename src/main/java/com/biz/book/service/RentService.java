package com.biz.book.service;

import java.time.LocalDate;
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
	
	public List<RentVO> selectAllReturns() {

		return rentMapper.selectAllReturns();
	}

	public List<RentVO> findByRentName(String searchDate) {

		return rentMapper.findByRentDate(searchDate);
	}

	public RentVO findByRentID(long rent_seq) {

		return rentMapper.findByRentID(rent_seq);
	}

	public int insertRent(RentVO rentVO) {

		/*
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String today=sd.format(date);
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 7);
		
		String return_day=sd.format(cal.getTime());
		*/
		
		LocalDate ld=LocalDate.now();
		LocalDate ld_7=ld.plusDays(7);
		
		rentVO.setRent_date(ld.toString());
		rentVO.setRent_return_date(ld_7.toString());
		rentVO.setRent_return_yn("n");
		
		BookVO bookVO=bookService.findByBookID(rentVO.getRent_book_seq());
		bookVO.setBook_rent_yn("n");
		bookService.updateBook(bookVO, null);
		
		return rentMapper.insertRent(rentVO);
	}

	public int updateRent(RentVO rentVO) {

		rentVO.setRent_return_yn("y");
		
		BookVO bookVO=bookService.findByBookID(rentVO.getRent_book_seq());
		bookVO.setBook_rent_yn("y");
		bookService.updateBook(bookVO, null);
		
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










