import React from 'react'
import './navbar.css'
import { Link } from 'react-router-dom';
import { routes } from '../SiteManager';

const Navbar = () => {
  window.onload = function () {
    var mainListDiv = document.getElementById("mainListDiv"), mediaButton = document.getElementById("mediaButton");
    mediaButton.onclick = function () {
      "use strict";
      mainListDiv.classList.toggle("show_list");
      mediaButton.classList.toggle("active");
    };
  };
  return (
    <>
      <nav className="nav">
        <div className="container">
          <div className="logo">
            <a href="#">TrendHive</a>
          </div>
          <div className="main_list" id="mainListDiv">
            <ul>
              <div className='links'>
                <li><Link to={routes.home}>Home</Link></li>
                <li><Link to={routes.contactUs}>Contact</Link></li>
                <li><Link to={routes.aboutUs}>About TrendHive</Link></li>
                <li><Link to={routes.signUp}>Sign Up</Link></li>
              </div>
              <div className='searchBar'>
                <input type="text" placeholder='what are you looking for?' />
                <div className='searchIcon'>
                  <svg fill="#000000" height="24px" width="24px" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" viewBox="-24.42 -24.42 537.24 537.24" xmlSpace="preserve" stroke="#000000" strokeWidth="4.3956"><g id="SVGRepo_bgCarrier" strokeWidth="0"></g><g id="SVGRepo_tracerCarrier" strokeLinecap="round" strokeLinejoin="round"></g><g id="SVGRepo_iconCarrier"> <g> <g> <path d="M0,203.25c0,112.1,91.2,203.2,203.2,203.2c51.6,0,98.8-19.4,134.7-51.2l129.5,129.5c2.4,2.4,5.5,3.6,8.7,3.6 s6.3-1.2,8.7-3.6c4.8-4.8,4.8-12.5,0-17.3l-129.6-129.5c31.8-35.9,51.2-83,51.2-134.7c0-112.1-91.2-203.2-203.2-203.2 S0,91.15,0,203.25z M381.9,203.25c0,98.5-80.2,178.7-178.7,178.7s-178.7-80.2-178.7-178.7s80.2-178.7,178.7-178.7 S381.9,104.65,381.9,203.25z"></path> </g> </g> </g></svg>
                </div>
              </div>
            </ul>
          </div>
          <div className="media_button">
            <button className="main_media_button" id="mediaButton">
              <span></span>
              <span></span>
              <span></span>
            </button>
          </div>
        </div>
      </nav>
    </>
  )
}

export default Navbar
