package design.pattern.creational.simple.factory;

public class SimpleFactoryTester {

    public static void main(String[] args) {
        PostFactory.createPost("blog");
        PostFactory.createPost("news");
        PostFactory.createPost("product");
    }

}

class PostFactory {

    public static Post createPost(String postType) {
        switch (postType) {
        case "blog":
            return new BlogPost();
        case "news":
            return new NewsPost();
        case "product":
            return new ProductPost();
        default:
            throw new IllegalArgumentException("Illegal Argument");
        }

    }
}

abstract class Post {
    private long id;
    private String title;
    private String content;

}

class NewsPost extends Post {
    private String headline;

    public NewsPost() {
        super();
        System.out.println("NewsPost Instantiated");
    }
    

}

class BlogPost extends Post {
    private String author;
    private String[] tags;
    public BlogPost() {
        super();
        System.out.println("BlogPost Instantiated");
    }
}

class ProductPost extends Post {
    private String imageUrl;
    private String name;
    public ProductPost() {
        super();
        System.out.println("ProductPost Instantiated");
    }
}