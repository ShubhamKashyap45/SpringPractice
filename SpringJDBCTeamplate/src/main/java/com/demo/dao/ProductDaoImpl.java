package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	JdbcTemplate jdbcTeamplate;

	@Override
	public void saveProdct(Product p) {
		int n = jdbcTeamplate.update("insert into product301 values(?,?,?,?,?,?)",
				new Object[] { p.getPid(), p.getPname(), p.getQty(), p.getPrice(), p.getLdt(), p.getCid() });
	}

	@Override
	public void modifyProduct(Product p) {
		

		int m = jdbcTeamplate.update("update product301 set pname=?, qty=?, price=?, ldt=?, cid=? "
				+ "where pid=?",
				new Object[] { p.getPname(), p.getQty(), p.getPrice(), p.getLdt(), p.getCid(), p.getPid() });
	}

	@Override
	public void removeProduct(int dpid) {
		String sql = "delete from product301 where pid=?";
		int r = jdbcTeamplate.update(sql, dpid);
		
	}

	@Override
	public Product showById(int pid) {
		String sql = "select * from product301 where pid=?";
		return jdbcTeamplate.queryForObject(sql, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int r1 ) throws SQLException{
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setQty(rs.getInt("qty"));
				p.setPrice(rs.getDouble("price"));
				p.setCid(rs.getInt("cid"));
				return p;
			}
		},pid);
		
	}

	@Override
	public List<Product> findAll() {
		List<Product> plist=jdbcTeamplate.query("select * from product301", (rs,numrows)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			p.setLdt(rs.getDate(5).toLocalDate());
			p.setCid(rs.getInt(6));
			return p;
		});
		return plist;
	}

	@Override
	public List<Product> findByPrice(double price) {
		List<Product> plist=jdbcTeamplate.query("select * from product301 where price>?",new Object[] {price}, BeanPropertyRowMapper.newInstance(Product.class));
		if(plist.size()>0)
			return plist;
		else
			return null;
				
	}




}
