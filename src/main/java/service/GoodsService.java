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

	
	// goodsList
	public ArrayList<HashMap<String, Object>> getGoodList() {
		ArrayList<HashMap<String, Object>> list = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			goodsDao = new GoodsDao();
			list = goodsDao.selectGoodsList(conn);
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
	
	// goodsOne
	public HashMap<String, Object> getGoodsOne(int goodsCode) {
		HashMap<String, Object> map = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();			
			goodsDao = new GoodsDao();
			map = goodsDao.selectgoodsOne(conn, goodsCode);
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
	
	// goodsAdd
	public void addGodds(Goods goods, GoodsImg goodsImg, String dir) {
		goodsDao = new GoodsDao();
		goodsImgDao = new GoodsImgDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();	
			conn.setAutoCommit(false);
			
			HashMap<String, Integer> map = goodsDao.insertGoods(conn, goods);
			
			goodsImg.setGoodsCode(map.get("autoKey"));
			goodsImgDao.insertGoods(conn, goodsImg); // goodsImg.getGoodsCode() --> 0
			
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
	// goodsModify
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

	//goodsRemove
	public int removeGoods(Goods goods, GoodsImg goodsImg) {
		goodsDao = new GoodsDao();
		goodsImgDao = new GoodsImgDao();
		Connection conn = null;
		int row = 0;	
		try {
			conn = DBUtil.getConnection();
			row = goodsImgDao.deleteGoods(conn, goodsImg);
			if(row == 1) {
				row = goodsDao.deleteGoods(conn, goods);
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

}


