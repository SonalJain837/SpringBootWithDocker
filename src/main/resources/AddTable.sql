CREATE TABLE Topic
(
id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
topicName STRING,
description STRING,
);