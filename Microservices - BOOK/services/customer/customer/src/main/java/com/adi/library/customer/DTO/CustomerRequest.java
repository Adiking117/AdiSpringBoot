package com.adi.library.customer.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerRequest {

        private String id;

        @NotBlank(message = "Customer firstname is required")
        private String firstname;

        @NotBlank(message = "Customer lastname is required")
        private String lastname;

        @NotNull(message = "Customer Email is required")
        @Email(message = "Customer Email is not a valid email address")
        private String email;

        // No-argument constructor
        public CustomerRequest() {
        }

        // All-arguments constructor
        public CustomerRequest(String id, String firstname, String lastname, String email) {
                this.id = id;
                this.firstname = firstname;
                this.lastname = lastname;
                this.email = email;
        }

        // Getters
        public String getId() {
                return id;
        }

        public String getFirstname() {
                return firstname;
        }

        public String getLastname() {
                return lastname;
        }

        public String getEmail() {
                return email;
        }

        // Setters
        public void setId(String id) {
                this.id = id;
        }

        public void setFirstname(String firstname) {
                this.firstname = firstname;
        }

        public void setLastname(String lastname) {
                this.lastname = lastname;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        @Override
        public String toString() {
                return "CustomerRequest{" +
                        "id='" + id + '\'' +
                        ", firstname='" + firstname + '\'' +
                        ", lastname='" + lastname + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }
}
