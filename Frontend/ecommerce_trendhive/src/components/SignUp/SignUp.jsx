import React from 'react'
import myImg from './image.png'
import './signup.css'
import { Link } from 'react-router-dom'

export const SignUp = () => {
  return (
    <>
      <div style={{ height: '65px' }}></div>
      <div className='signup_container'>
        <div className='imageDiv'>
            <img src={myImg} alt="" />
        </div>
        <div className='signupInputDiv'>
          <h1>Create an Account</h1>
          <p style={{ margin: "6px 0px" }}>Enter your details below</p>
          <form action="" className='signupInputForm'>
            <input type="text" placeholder='Name' /><br />
            <input type="text" placeholder='Email or Phone Number' /><br />
            <input type="password" placeholder='Password' /><br />
            <input type="submit" className='submitbtn' value={'Create Account'} />
            <div className='google_signup'>
              <img height={'25px'} width={'25px'} src="https://cdn1.iconfinder.com/data/icons/google-s-logo/150/Google_Icons-09-512.png" alt="" />
              <p style={{ margin: '0px 4px' }}>Sign Up With google</p>
            </div>
            <p style={{ textAlign: 'center' }}>Already have an Account? <Link to="/signin">Sign in</Link></p>
          </form>
        </div>
      </div>
    </>
  )
}
