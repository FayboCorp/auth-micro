package uship.auth.authmicro.model.routes

enum class Roles(val role: String) {

    CUSTOMER("User"),
    SUPPLIER("Supplier"),
    ADMIN("Admin"),
    SUPER_ADMIN("SuperAdmin")

}