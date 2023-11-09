#!/usr/bin/env python

import sys
from confluent_kafka import Consumer, OFFSET_BEGINNING
from argparse import ArgumentParser, FileType
from configparser import ConfigParser
from confluent_kafka import Producer

if __name__ == '__main__':
    # Parse the command line.
    parser = ArgumentParser()
    parser.add_argument('--config_file', type=FileType('r'))
    args = parser.parse_args()

    # Parse the configuration.
    # See https://github.com/edenhill/librdkafka/blob/master/CONFIGURATION.md
    config_parser = ConfigParser()
    config_parser.read_file(args.config_file)
    config = dict(config_parser['default'])

    # Create Producer instance
    producer = Producer(config)

    topic = "test"
    message_body = "This is a test message"

     # Produce data 
    producer.produce(topic,message_body)

    # Block until the messages are sent.
    producer.poll(10000)
    producer.flush()