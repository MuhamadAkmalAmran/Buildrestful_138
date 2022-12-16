/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author akmal
 */
public class Product {
    
    //variable id dan name
    private String id;
    private String name;
    private Double price;
    private Double disc;
    private Double total;
    
    //method untuk mengambil variabel id
    public String getId()
    {
        return id;
    }
    
    //method untuk memberikan nilai
    public void setId(String id)
    {
        this.id = id;
    }
    //method untuk mengambil variabel name
    public String getName()
    {
        return name;
    }
    
    //method untuk memberikan nilai
    public void setName(String name)
    {
        this.name = name;
    }
    //method untuk mengambil variabel name
    public Double getPrice()
    {
        return price;
    }
    
    //method untuk memberikan nilai
    public void setPrice(Double price)
    {
        this.price = price;
    }
    //method untuk mengambil variabel name
    public Double getDisc()
    {
        return disc;
    }
    
    //method untuk memberikan nilai
    public void setDisc(Double disc)
    {
        this.disc = disc;
    }
    //method untuk mengambil variabel name
    public Double getTotal()
    {
        return total ;
    }
    
    //method untuk memberikan nilai
    public void setTotal()
    {
        this.total = price - (price *disc);
    }
    
}
