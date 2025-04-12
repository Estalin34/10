    package com.example.spring_boot.service;

    import com.example.spring_boot.models.Product;
    import com.example.spring_boot.models.User;
    import com.example.spring_boot.repository.ProductRepository;
    import com.example.spring_boot.repository.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.stereotype.Service;

    @Service
    public class UserService {

        @Autowired
        UserRepository repository;
        @Autowired
        ProductRepository productRepository;

        public User save(User user) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            return this.repository.save(user);

        }
        public User addProductToUser(Long userId, Long productId) {
            User user = repository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            user.getProducts().add(product);
            return repository.save(user); // Esto inserta en la tabla intermedia
        }




    }
