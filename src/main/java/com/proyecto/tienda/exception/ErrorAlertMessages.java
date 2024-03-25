package com.proyecto.tienda.exception;

public class ErrorAlertMessages {

    //ErrorAlertMessages para el usuario
    public static final String USER_NOT_EXISTS_MESSAGE = "El cliente no se encuentra registrado en la base de datos";
    public static final String USER_INCORRECT_PASSWORD_MESSAGE = "Contraseña incorrecta";
    public static final String USER_ALREADY_EXISTS_MESSAGE = "El cliente ya se encuentra registrado en la base de datos";
    public static final String USER_BAD_FORMAT_EMAIL_MESSAGE = "El email no tiene el formato requerido";

    //ErrorAlertMessages para la compra
    public static final String PURCHASE_ALREADY_EXISTS_MESSAGE = "La compra ya se encuentra registrada en la base de datos";
    public static final String PURCHASE_NOT_EXISTS_MESSAGE = "La compra no se encuentra registrada en la base de datos";

    //ErrorAlertMessages para las marcas
    public static final String BRAND_ALREADY_EXISTS_MESSAGE = "La marca ya se encuentra registrada en la base de datos";
    public static final String BRAND_NOT_EXISTS_MESSAGE = "La marca no se encuentra registrada en la base de datos";

    //ErrorAlertMessages para los productos
    public static final String PRODUCT_ALREADY_EXISTS_MESSAGE = "El producto ya se encuentra registrado en la base de datos";
    public static final String PRODUCT_NOT_EXISTS_MESSAGE = "El producto no se encuentra registrado en la base de datos";

    public static final String TYPE_ALREADY_EXISTS_MESSAGE = "El tipo de deproducto ya se encuentra registrado";
    public static final String TYPE_NOT_EXISTS_MESSAGE = "El tipo de de producto no se encuentra registrado";


    //ErrorAlertMessages para el carrito
    public static final String CART_NOT_EXISTS_MESSAGE = "El carrito del usuario no se encuentra registado";
    public static final String CART_ALREADY_EXISTS_MESSAGE = "El carrito del usuario ya se encuentra registado";
}
