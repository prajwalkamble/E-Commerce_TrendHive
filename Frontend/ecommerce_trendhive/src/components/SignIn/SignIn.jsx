import React from 'react'
import myImg from './image.png'
import './signin.css'

export const SignIn = () => {
  return (
    <>
      <div style={{ height: '65px' }}></div>
      <div className='signup_container'>
        <div className='imageDiv'>
          <img src={myImg} alt="" />
        </div>
        <div className='signupInputDiv'>
          <h1>Welcome Back</h1>
          <p style={{ margin: "6px 0px" }}>Enter your details below</p>
          <form action="" className='signupInputForm'>
            <input type="text" placeholder='Name or Phone Number' /><br />
            <input type="password" placeholder='Password' /><br />
            <div className='login_bottom'>
              <input type="submit" className='submitbtn'  value={'Login'} />
              <p><a href="#">Forgot Password?</a></p>
            </div>
          </form>
        </div>
      </div>
    </>
  )
}
