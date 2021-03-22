package clothes_shop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Entities {
	
	@Entity
	@Table(name = "USERS", schema = "CLOTHES_SHOP")
	public class Users{
		@JoinColumn(name = "id_role", referencedColumnName = "id" )
		private Role role;
		
		@OneToOne(mappedBy = "users")
		private Orders orders;
	}

	@Entity
	@Table(name = "ROLES", schema = "CLOTHES_SHOP")
	public class Roles{
		
		@OneToOne(mappedBy = "role")
		private Users users;
	}
	
	@Entity
	@Table(name = "ORDERS", schema = "CLOTHES_SHOP")
	public class Orders{
		@JoinColumnName(name = "id_user", referencedColumnName = "id")
		private Users users;
		
		@OneToOne(mappedBy = "orderItems")
		private OrderItems orderItem;
		
	}
	
	
	@Entity
	@Table(name = "PRODUCT_CATEGORY", schema = "CLOTHES_SHOP")
	public class Product_Categories{
		
		@JoinColumnName(name = "id_category", referencedColumnName = "id")
		private Category category;
		
		@OneToOne(mappedBy = "p_cat")
		private Products products;
	}
	
	@Entity
	@Table(name = "CATEGORY", schema = "CLOTHES_SHOP")
	
	public class Category{
		@OneToOne(mappedBy = "category")
		private Product_Category productCategory;
	}
	
	
	@Entity
	@Table(name = "PRODUCTS", schema = "CLOTHES_SHOP")
	
	public class Products{
		@JoinColumnName(name = "id_product_category", referencedColumnName = "id")
		private Product_Category p_cat;
		
		
		@OneToOne(mappedBy = "orderItems")
		private Products product;
	}
	
	@Entity
	@Table(name = "ORDERITEMS", schema = "CLOTHES_SHOP")
	public class OrderItems{
		
		@JoinColumnName(name = "id_order", referencedColumnName = "id")
		@JoinColumnName(name = "id_product", referencedColumnName = "id")
		private OrderItems orderItems;
		

	}
	
}
