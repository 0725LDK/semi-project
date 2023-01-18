package service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.GoodsDao;
import dao.GoodsImgDao;
import util.DBUtil;
import vo.Goods;
import vo.GoodsImg;

public class GoodsService {
	private GoodsDao goodsDao;
	private GoodsImgDao goodsImgDao;
	
	// 신상품 리스트 출력
	public ArrayList<HashMap<String, Object>> getGoodsNewList(int beginRow, int rowPerPage) {
		ArrayList<HashMap<String, Object>> newList = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();		
			goodsDao = new GoodsDao();
			newList = goodsDao.selectGoodsNewList(conn, beginRow, rowPerPage);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newList;
	}
	
	
	
	// 인기상품 리스트 출력
	public ArrayList<HashMap<String, Object>> getGoodsHitList(int hit) {
		ArrayList<HashMap<String, Object>> hitList = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();		
			goodsDao = new GoodsDao();
			hitList = goodsDao.selectGoodsHitList(conn, hit);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hitList;
	}
	
	// 카테고리별 상품 리스트
	public ArrayList<HashMap<String, Object>> getGoodsCategoryList(String goodsCategory) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();		
			goodsDao = new GoodsDao();
			list = goodsDao.selectGoodsCategoryList(conn, goodsCategory);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}	
	
	// 상품 리스트
	public ArrayList<HashMap<String, Object>> getGoodsList(String goodsSearch) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();		
			goodsDao = new GoodsDao();
			list = goodsDao.selectGoodsList(conn, goodsSearch);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 상품 상세페이지
	public HashMap<String, Object> getGoodsOne(int goodsCode) {
		HashMap<String, Object> map = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();			
			goodsDao = new GoodsDao();
			map = goodsDao.selectGoodsOne(conn, goodsCode);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	// ADD
	public void addGoods(Goods goods, GoodsImg goodsImg, String dir) {
		goodsDao = new GoodsDao();
		goodsImgDao = new GoodsImgDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();			
			HashMap<String, Integer> map = goodsDao.insertGoods(conn, goods);		
			int row = map.get("row");
			if(row == 1) {
				goodsImg.setGoodsCode(map.get("autoKey"));
				goodsImgDao.insertGoods(conn, goodsImg); // itemImg.getItemNo() --> 0
				System.out.println("성공");							
			} else {
				System.out.println("실패");					
			}
				conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
                // db작업에 실패시 이미 업로드되어 버린 파일을 불러와 삭제
				File f = new File(dir+"\\"+goodsImg.getFilename());
				if(f.exists()) {
					f.delete();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Modify
	public int modifyGoods(Goods goods, GoodsImg goodsImg, String dir) {
		goodsDao = new GoodsDao();
		goodsImgDao = new GoodsImgDao();
		Connection conn = null;
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			row = goodsDao.updateGoods(conn, goods);
			if(row == 1) {
				row = goodsImgDao.updateGoods(conn, goodsImg);
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// 상품 리뷰
	public ArrayList<HashMap<String, Object>> getGoodsReview(int goodsCode) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();		
			goodsDao = new GoodsDao();
			list = goodsDao.selectGoodsReview(conn, goodsCode);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}	
	
	
	
	
/*
	// 상품 삭제
	public int removeGoods(int goodsCode) {
		goodsDao = new GoodsDao();
		goodsImgDao = new GoodsImgDao();
		Connection conn = null;
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			row = goodsImgDao.deleteGoods(conn, goodsCode);
			if(row == 1) {
				row = goodsDao.deleteGoods(conn, goodsCode);
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
*/
}