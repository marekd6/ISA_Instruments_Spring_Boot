#!/bin/sh

export ORCHESTRA_INSTRUMENT_URL
export ORCHESTRA_SECTION_URL

envsubst '${ORCHESTRA_SECTION_URL}, ${ORCHESTRA_INSTRUMENT_URL}' < /config.template > /etc/nginx/nginx.conf

exec "$@"
