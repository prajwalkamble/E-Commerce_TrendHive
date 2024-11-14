import React from 'react'
import './contact.css'
import callIcon from './call_icon.png'
import emailIcon from './email_icon.png'

export const ContactUs = () => {
  return (
    <>
      <div style={{ height: '65px' }}></div>
      <div className='contactContainer'>
        <div className='contactInfo'>
          <div className='callus'>
            <img className='callicon' src={callIcon} alt="" />
            <h3>Call to Us</h3>
          </div>
          <p>We are available 24/7,7 days a week.</p>
          <p>Phone: +998451656498</p>
          <hr />
          <div className='mailus'>
            <img className='mailicon' src={emailIcon} alt="" />
            <h3>Write to Us</h3>
          </div>
          <p>Fill out our form and we will contact <br /> you within 24 hours.</p>
          <p>Emails: customercare@trendhive.com</p>
          <p>Emails: support@trendhive.com</p>
        </div>
        <div className='userInfo'>
          <div>
            <input type="text" placeholder='Your Name *'/>
            <input type="email" placeholder='Your Email *'/>
            <input type="text" placeholder='Your Phone *'/>
          </div>
          <div>
            <textarea placeholder='Your Message' name="" id=""></textarea>
          </div>
          <div className='sendbtndiv'>
            <button>Send Message</button>
          </div>
        </div>
      </div>
    </>
  )
}
