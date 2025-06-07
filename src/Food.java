public class Food {
    public int id;
    public String name;
    public float price;
    public String time;
    public float delivery;
    public float rating;
    public String image;
    public int restaurantId;   
    public String description;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public float getPrice(){return price;}
    public void setPrice(float price ){this.price = price; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public float getDelivery(){return delivery;}
    public void setDelivery(float delivery ){this.delivery = delivery; }

    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public int getrestaurantId() { return restaurantId; }
    public void setrestaurantId(int restaurantId) { this.restaurantId = restaurantId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
