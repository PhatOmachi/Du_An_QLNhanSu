/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import entity.TaiKhoan;




/**
 *
 * @author TAN LOC
 */
public class Auth {

    public static TaiKhoan taikhoan = null;


    public static void clear() {
        Auth.taikhoan = null;
    }

    public static boolean isLogin() {
        return Auth.taikhoan != null;
    }


}
