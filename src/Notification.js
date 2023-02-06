import {notification} from "antd";

const openNotificationWithIcon = (type, message, description, duration) => {
    notification[type]({message, description, duration});
};

export const successNotification = (message, description, duration) =>
    openNotificationWithIcon('success', message, description, duration);

export const errorNotification = (message, description) =>
    openNotificationWithIcon('error', message, description);

export const infoNotification = (message, description) =>
    openNotificationWithIcon('info', message, description);

export const warningNotification = (message, description) =>
    openNotificationWithIcon('warning', message, description);