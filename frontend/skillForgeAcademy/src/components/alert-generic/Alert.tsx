import React from 'react';
import { AlertProps } from '@/model/alert/alert-generic';


type AlertType = 'success' | 'error';

const Alert: React.FC<AlertProps & { type: AlertType }> = ({ message, showIcon, type }) => {
  const alertStyles: Record<AlertType, string> = {
    success: "bg-green-100 border border-green-400 text-green-700",
    error: "bg-red-100 border border-red-400 text-red-700",
  };

  return (
    <div className={`${alertStyles[type]} px-4 py-3 rounded relative my-4`} role="alert">
      {showIcon && (
        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5" stroke="currentColor" className="w-6 h-6 inline-block mr-2">
          <path strokeLinecap="round" strokeLinejoin="round" d="M12 9v3.75m-9.303 3.376c-.866 1.5.217 3.374 1.948 3.374h14.71c1.73 0 2.813-1.874 1.948-3.374L13.949 3.378c-.866-1.5-3.032-1.5-3.898 0L2.697 16.126zM12 15.75h.007v.008H12v-.008z" />
        </svg>
      )}
      <span className="block sm:inline py-4 text-sm">{message}</span>
    </div>
  );
};

export default Alert;
