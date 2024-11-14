import React from 'react'
import './checkout.css'
import item1 from './item1.png'
import item2 from './item2.png'

export const Checkout = () => {
  return (
    <>
      <div style={{ height: '65px' }}></div>
      <div className='checkout_container' >
        <div className='checkout_info'>
          <h1>Billing Details</h1>
          <p>First Name<span className='astric'>*</span></p>
          <input type="text" /><br />
          <p>Company Name</p>
          <input type="text" /><br />
          <p>Street Address<span className='astric'>*</span></p>
          <input type="text" /><br />
          <p>Apartment, floor, etc. (optional)</p>
          <input type="text" /><br />
          <p>Town / City<span className='astric'>*</span></p>
          <input type="text" /><br />
          <p>Phone Number<span className='astric'>*</span></p>
          <input type="text" /><br />
          <p>Email Address<span className='astric'>*</span></p>
          <input type="email" /><br />
          <input style={{ width: '14px' }} className='checkout_checkbox' type="checkbox" /> <p style={{ display: 'inline' }}>Save this information for faster check-out next time</p>
        </div>
        <div className='checkout_total'>
          <div className='billing_items'>
            <div className='billing_item'>
              <div className='billing_item_name'>
                <img src={item1} alt="" />
                <p>LCD Moniter</p>
              </div>
              <div>
                <p>$650</p>
              </div>
            </div>
            <div className='billing_item'>
              <div className='billing_item_name'>
                <img src={item2} alt="" />
                <p>H1 Gamepad</p>
              </div>
              <div>
                <p>$1100</p>
              </div>
            </div>
          </div>
          <div className='billing_cost'>
            <div className='billing_cost_price'>
              <p>subtotal:</p>
              <p>$1750</p>
            </div>
            <hr />
            <div className='billing_cost_price'>
              <p>Shipping</p>
              <p>Free</p>
            </div>
            <hr />
            <div className='billing_cost_price'>
              <p>Total</p>
              <p>$1750</p>
            </div>
          </div>
          <div className='billing_payment'>
            <div>
              <input type="radio" name='payment_type' />Bank
            </div>
            <div>
              <input type="radio" name='payment_type' />Cash on delivery
            </div>
            <div>
              <input type="text" className='coupon_code' placeholder='Coupon Code' />
              <button>Apply Coupon</button>
            </div>
            <button>Place Order</button>
          </div>
        </div>
      </div>
    </>
  )
}
