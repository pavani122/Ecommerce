package com.techouts.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.techouts.entities.Product;

public class ProductDao {

	private HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void save(Product product) {
		this.template.save(product);
	}

	public List<Product> getProductByCategory(String categoryname) {
		String query="from Product where categoryName= :categoryname";
        List<Product> list =(List<Product>) this.template.findByNamedParam(query, "categoryname", categoryname);
        System.out.println(".....");
        System.out.println(list.size());
		return list;
		
	}

	public Product getProductById(int id) {
		Product product=this.template.get(Product.class, id);
		return product;
	}

}
