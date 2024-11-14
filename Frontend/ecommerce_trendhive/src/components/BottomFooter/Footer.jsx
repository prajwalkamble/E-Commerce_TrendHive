import React from 'react'
import './footer.css'

const Footer = () => {
  return (
    <>
      <div className='main_footer_container'>
        <div className='footer_container' >
          <div>
            <h4>TrendHive</h4>
            <h4>Subscribe</h4>
            <p>
              <a href='#'>Get 10% off for your first order</a>
            </p>
            <div className='email_input_div'>
              <input className='email_input' type="text" placeholder='Enter your email' />
            </div>
          </div>
          <div>
            <h4>Support</h4>
            <p>
              <a href='#'>ExcelR, Baner, Pune, <br /> India</a>
            </p>
            <p>
              <a href='#'>trendhive@gmail.com</a>
            </p>
            <p>
              <a href='#'>+88015-88888-9999</a>
            </p>
          </div>
          <div>
            <h4>Account</h4>
            <p>
              <a href='#'>My Account</a>
            </p>
            <p>
              <a href='#'>Login / Register</a>
            </p>
            <p>
              <a href='#'>Cart</a>
            </p>
            <p>
              <a href='#'>Wishlist</a>
            </p>
            <p>
              <a href='#'>Shop</a>
            </p>
          </div>
          <div>
            <h4>Quick Link</h4>
            <p>
              <a href='#'>Privacy Policy</a>
            </p>
            <p>
              <a href='#'>Terms of Use</a>
            </p>
            <p>
              <a href='#'>FAQ</a>
            </p>
            <p>
              <a href='#'>Contact</a>
            </p>
          </div>
          <div>
            <h4>Download App</h4>
          </div>
        </div>
        <div>
          <p style={{padding:'20px'}}>&#169; Copyright ExcelR 2024.All rights reserved</p>
        </div>
      </div>
    </>
  )
}

export default Footer
